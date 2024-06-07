package com.sight.JOOQ_first_look.film

import org.jooq.DSLContext
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.references.FILM
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
}