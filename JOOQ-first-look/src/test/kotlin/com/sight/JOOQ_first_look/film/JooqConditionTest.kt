package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.actor.ActorFilmographySearchOption
import com.sight.JOOQ_first_look.actor.ActorRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqConditionTest(
        @Autowired private val actorRepository: ActorRepository
) {

    @Test
    fun `AND 조건 검색 - firstName과 lastName이 일치하는 배우 조회`() {
        // given
        val firstName = "ED"
        val lastName = "CHASE"

        // when
        val actorList = actorRepository.findByFirstnameAndLastName(firstName, lastName)

        // then
        assertThat(actorList).hasSize(1)
    }

    @Test
    fun `OR 조건 검색 - firstName 또는 lastName이 일치하는 배우 조회`() {
        // given
        val firstName = "ED"
        val lastName = "CHASE"

        // when
        val actorList = actorRepository.findByFirstnameOrLastName(firstName, lastName)

        // then
        assertThat(actorList).hasSizeGreaterThan(1)
    }

    @Test
    fun `IN 절 - 동적 조건 검색`() {
        // given
        val idList = listOf(1L)

        // when
        val actorList = actorRepository.findByActorIdIn(idList)

        // then
        assertThat(actorList).hasSize(1)
    }

    @Test
    fun `IN 절 - 동적 조건 검색 - empty list시 제외`() {
        // given

        // when
        val actorList = actorRepository.findByActorIdIn(emptyList())

        // then
        assertThat(actorList).hasSizeGreaterThan(1)
    }

    @Test
    fun `다중 조건 검색 - 배우 이름으로 조회`() {
        // given
        val searchOption = ActorFilmographySearchOption(actorName = "LOLLOBRIGIDA")

        // when
        val actorFilmographies = actorRepository.findActorFilmography(searchOption)

        // then
        assertThat(actorFilmographies).hasSize(1)
    }

    @Test
    fun `다중 조건 검색 - 배우 이름과 영화 제목으로 조회`() {
        // given
        val searchOption = ActorFilmographySearchOption(
                actorName = "LOLLOBRIGIDA",
                filmTitle = "COMMANDMENTS EXPRESS"
        )

        // when
        val actorFilmographies = actorRepository.findActorFilmography(searchOption)

        // then
        assertThat(actorFilmographies).hasSize(1)
    }
}