package com.sight.JOOQ_first_look.film

import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Film
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqDaoWrapperTest(
        @Autowired private val filmRepositoryIsA: FilmRepositoryIsA,
        @Autowired private val filmRepositoryHasA: FilmRepositoryHasA
) {

    @Test
    fun `상속) 자동생성 DAO 사용 - 영화길이가 100 ~ 180 분 사이인 영화 조회`() {
        // given
        val start = 100
        val end = 180

        // when
        val films = filmRepositoryHasA.findByRangeBetween(from = start, to = end)

        // then
        Assertions.assertThat(films).hasSizeGreaterThan(0)
        Assertions.assertThat(films).allSatisfy {
            Assertions.assertThat(it.length).isBetween(start, end)
        }
    }
}