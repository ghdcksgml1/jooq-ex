package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.film.dto.FilmWithActor
import com.sight.JOOQ_first_look.film.dto.SimpleFileInfo
import org.jooq.DSLContext
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.references.ACTOR
import org.jooq.generated.tables.references.FILM
import org.jooq.generated.tables.references.FILM_ACTOR
import org.springframework.stereotype.Repository

@Repository
class FilmRepository(
        private val dslContext: DSLContext
) {
    fun findById(id: Long): Film? {
        return dslContext.select(FILM)
                .from(FILM)
                .where(FILM.FILM_ID.eq(id))
                .fetchOneInto(Film::class.java)
    }

    fun findSimpleFileInfoById(id: Long): SimpleFileInfo? {
        return dslContext.select(
                FILM.FILM_ID,
                FILM.TITLE,
                FILM.DESCRIPTION
        ).from(FILM)
                .where(FILM.FILM_ID.eq(id))
                .fetchOneInto(SimpleFileInfo::class.java)
    }

    fun findFilmWithActorList(page: Long, pageSize: Long): List<FilmWithActor> {

        return dslContext.select(
                FILM,
                FILM_ACTOR,
                ACTOR
        ).from(FILM)
                .join(FILM_ACTOR).on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
                .join(ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
                .offset((page - 1) * pageSize)
                .limit(pageSize)
                .fetchInto(FilmWithActor::class.java)
    }
}