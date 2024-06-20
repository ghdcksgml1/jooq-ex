package com.sight.JOOQ_first_look.web

import com.sight.JOOQ_first_look.film.dto.FilmWithActor

data class FilmWithActorPagedResponse(
        val pagedResponse: PagedResponse,
        val filmActorList: List<FilmActorResponse>
)

data class FilmActorResponse(
        val filmTitle: String,
        val actorFullName: String,
        val filmId: Long
) {
    constructor(filmWithActor: FilmWithActor) : this(
            filmTitle = filmWithActor.film?.title ?: "",
            actorFullName = "${filmWithActor.actor!!.firstName} ${filmWithActor.actor!!.lastName}",
            filmId = filmWithActor.film?.filmId ?: 0L
    )
}
