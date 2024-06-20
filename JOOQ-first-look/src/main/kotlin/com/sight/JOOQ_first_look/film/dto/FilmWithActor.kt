package com.sight.JOOQ_first_look.film.dto

import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.pojos.FilmActor

data class FilmWithActor(
        val film: Film?,
        val filmActor: FilmActor?,
        val actor: Actor?
)
