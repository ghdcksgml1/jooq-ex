package com.sight.JOOQ_first_look.actor

import com.sight.JOOQ_first_look.actor.dto.ActorFilmography
import com.sight.JOOQ_first_look.actor.dto.ActorFilmographySearchOption
import com.sight.JOOQ_first_look.actor.dto.ActorUpdateRequest
import com.sight.JOOQ_first_look.utils.jooq.JooqListConditionUtil.inIfNotEmpty
import org.jooq.Condition
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.Field
import org.jooq.generated.tables.daos.ActorDao
import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.records.ActorRecord
import org.jooq.generated.tables.references.ACTOR
import org.jooq.generated.tables.references.FILM
import org.jooq.generated.tables.references.FILM_ACTOR
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

@Repository
class ActorRepository(
    configuration: Configuration,
    private val dslContext: DSLContext,
) : ActorDao(configuration = configuration) {
    fun findByFirstnameAndLastName(firstName: String, lastName: String): List<Actor> {
        return dslContext.selectFrom(ACTOR)
            .where(
                ACTOR.FIRST_NAME.eq(firstName),
                ACTOR.LAST_NAME.eq(lastName)
            )
            .fetchInto(Actor::class.java)
    }

    fun findByFirstnameOrLastName(firstName: String, lastName: String): List<Actor> {
        return dslContext.selectFrom(ACTOR)
            .where(
                ACTOR.FIRST_NAME.eq(firstName)
                    .or(ACTOR.LAST_NAME.eq(lastName))
            )
            .fetchInto(Actor::class.java)
    }

    fun findByActorIdIn(idList: List<Long>): List<Actor> {
        return dslContext.selectFrom(ACTOR)
            .where(inIfNotEmpty(ACTOR.ACTOR_ID, idList))
            .fetchInto(Actor::class.java)
    }

    fun findActorFilmography(searchOption: ActorFilmographySearchOption): List<ActorFilmography> {
        val actorListMap = dslContext.select(
            ACTOR,
            FILM,
        ).from(ACTOR)
            .join(FILM_ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
            .join(FILM).on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
            .where(
                containsIfNotBlank(ACTOR.FIRST_NAME.concat(" ").concat(ACTOR.LAST_NAME), searchOption.actorName),
                containsIfNotBlank(FILM.TITLE, searchOption.filmTitle),
            )
            .fetchGroups(
                { record -> record[ACTOR.name, Actor::class.java] },
                { record -> record[FILM.name, Film::class.java] }
            )

        return actorListMap.entries
            .map { entry -> ActorFilmography(entry.key, entry.value) }
    }

    private fun containsIfNotBlank(field: Field<String?>, inputValue: String?): Condition {
        if (inputValue.isNullOrBlank()) {
            return DSL.noCondition()
        }

        return field.likeRegex(inputValue)
    }

    fun saveByDao(actor: Actor): Actor {
        insert(actor)
        return actor
    }

    fun saveByRecord(actor: Actor): ActorRecord {
        val actorRecord = dslContext.newRecord(ACTOR, actor)
        actorRecord.insert()
        return actorRecord
    }

    fun saveWithReturningId(actor: Actor): Long? {
        return dslContext.insertInto(
            ACTOR,
            ACTOR.FIRST_NAME,
            ACTOR.LAST_NAME,
        ).values(
            actor.firstName,
            actor.lastName
        ).returningResult(ACTOR.ACTOR_ID)
            .fetchOneInto(Long::class.java)
    }

    fun saveWithReturning(actor: Actor): Actor? {
        return dslContext.insertInto(
            ACTOR,
            ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE
        ).values(
            actor.firstName, actor.lastName, actor.lastUpdate
        ).returningResult(ACTOR)
            .fetchOneInto(Actor::class.java)
    }

    fun bulkInsertWithRows(actorList: List<Actor>) {
        val rows = actorList.map { actor ->
            DSL.row(
                actor.firstName,
                actor.lastName,
                actor.lastUpdate
            )
        }

        dslContext.insertInto(
            ACTOR,
            ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE
        ).valuesOfRows(rows)
            .execute()
    }

    override fun update(actor: Actor?) {
        super.update(actor)
    }

    fun findByActorId(actorId: Long): Actor? {
        return dslContext.selectFrom(ACTOR)
            .where(ACTOR.ACTOR_ID.eq(actorId))
            .fetchOneInto(Actor::class.java)
    }

    fun updateWithDto(newActorId: Long, request: ActorUpdateRequest): Int {
        val firstName = request.firstName?.let { DSL.`val`(request.firstName) } ?: DSL.noField(ACTOR.FIRST_NAME)
        val lastName = request.lastName?.let { DSL.`val`(request.lastName) } ?: DSL.noField(ACTOR.LAST_NAME)

        return dslContext.update(ACTOR)
            .set(ACTOR.FIRST_NAME, firstName)
            .set(ACTOR.LAST_NAME, lastName)
            .where(ACTOR.ACTOR_ID.eq(newActorId))
            .execute()
    }

    fun updateWithRecord(newActorId: Long, request: ActorUpdateRequest): Int? {
        val record = dslContext.fetchOne(ACTOR, ACTOR.ACTOR_ID.eq(newActorId))

        request.firstName?.let { record!!.firstName = request.firstName }
        request.lastName?.let { record!!.lastName = request.lastName }

        return record?.store()
    }

    fun delete(newActorId: Long): Int {
        return with(dslContext) {
            deleteFrom(ACTOR)
                .where(ACTOR.ACTOR_ID.eq(newActorId))
                .execute()
        }
    }

    fun deleteWithRecord(actor: Actor): Int? {
        val record = dslContext.fetchOne(ACTOR, ACTOR.ACTOR_ID.eq(actor.actorId))
        return record?.delete()
    }

    fun findRecordByActorId(actorId: Long): ActorRecord? {
        val record = dslContext.fetchOne(ACTOR, ACTOR.ACTOR_ID.eq(actorId))
        return record
    }
}