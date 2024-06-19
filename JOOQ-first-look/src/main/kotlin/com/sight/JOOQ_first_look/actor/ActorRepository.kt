package com.sight.JOOQ_first_look.actor

import com.sight.JOOQ_first_look.utils.jooq.JooqListConditionUtil.inIfNotEmpty
import org.jooq.Condition
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.Field
import org.jooq.generated.tables.daos.FilmDao
import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.references.ACTOR
import org.jooq.generated.tables.references.FILM
import org.jooq.generated.tables.references.FILM_ACTOR
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository

@Repository
class ActorRepository(
        configuration: Configuration,
        private val dslContext: DSLContext,
) : FilmDao(configuration = configuration) {
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
}