package com.sight.JOOQ_first_look.film

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FilmRepositoryTest(
        @Autowired val filmRepository: FilmRepository
) {
    @Test
    fun `1) 영화정보 조회`() {
        val film = filmRepository.findById(1L)
        Assertions.assertThat(film).isNotNull
    }
}