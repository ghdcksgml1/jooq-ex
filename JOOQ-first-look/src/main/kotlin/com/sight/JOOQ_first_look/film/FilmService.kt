package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.web.FilmActorResponse
import com.sight.JOOQ_first_look.web.FilmWithActorPagedResponse
import com.sight.JOOQ_first_look.web.PagedResponse
import org.springframework.stereotype.Service

@Service
class FilmService(
        val filmRepository: FilmRepository
) {
    fun getFilmActorPageResponse(page: Long, pageSize: Long): FilmWithActorPagedResponse {
        val filmActorList = filmRepository.findFilmWithActorList(page, pageSize)
                .map { FilmActorResponse(it) }
        return FilmWithActorPagedResponse(
                pagedResponse = PagedResponse(page, pageSize),
                filmActorList = filmActorList
        )
    }
}