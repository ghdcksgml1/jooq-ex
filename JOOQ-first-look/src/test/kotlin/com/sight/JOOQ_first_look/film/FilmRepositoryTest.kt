package com.sight.JOOQ_first_look.film

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FilmRepositoryTest(
        @Autowired val filmRepository: FilmRepository,
        @Autowired val filmService: FilmService
) {
    @Test
    fun `1) 영화정보 조회`() {
        val film = filmRepository.findById(1L)
        Assertions.assertThat(film).isNotNull
    }

    @Test
    fun `2) 영화정보 간략 조회`() {
        val simpleFilmInfo = filmRepository.findSimpleFileInfoById(1L)
        Assertions.assertThat(simpleFilmInfo).hasNoNullFieldsOrProperties()
    }

    @Test
    fun `3) 영화와 영화에 출연한 배우 정보를 페이징하여 조회`() {
        val filmActorPageResponse = filmService.getFilmActorPageResponse(1L, 20L)
        println(filmActorPageResponse)
        Assertions.assertThat(filmActorPageResponse.filmActorList).hasSize(20)
    }
}