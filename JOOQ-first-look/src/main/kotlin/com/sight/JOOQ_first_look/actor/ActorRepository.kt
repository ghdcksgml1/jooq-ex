package com.sight.JOOQ_first_look.actor

import org.jooq.Condition
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.TableField
import org.jooq.generated.tables.daos.FilmDao
import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.records.ActorRecord
import org.jooq.generated.tables.references.ACTOR
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

    private fun inIfNotEmpty(actorId: TableField<ActorRecord, Long?>, idList: List<Long>): Condition {
        if (idList.isEmpty()) {
            return DSL.noCondition()
        }
        return actorId.`in`(idList)
    }
}