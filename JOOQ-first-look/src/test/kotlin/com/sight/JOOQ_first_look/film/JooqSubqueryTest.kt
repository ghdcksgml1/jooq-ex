package com.sight.JOOQ_first_look.film

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class JooqSubqueryTest(
        @Autowired private val filmRepository: FilmRepositoryHasA
) {
    @Test
    @DisplayName("""
        영화별 대여료가
        1.0 이하면 'Cheap',
        3.0 이하면 'Moderate',
        그 이상이면 'Expensive'로 분류하고,
        각 영화의 총 재고 수를 조회한다.
    """)
    fun `스칼라 서브쿼리 예제`() {
        val filmTitle = "EGG"

        val priceSummaryList = filmRepository.findFilmPriceSummaryByFilmTitle(filmTitle)
        println(priceSummaryList)
    }

    @Test
    @DisplayName("평균 대여 기간이 가장 긴 영화부터 정렬해서 조회한다.")
    fun `from절 서브쿼리 인라인 뷰 예제`() {

    }

    @Test
    @DisplayName("대여된 기록이 있는 영화가 있는 영화만 조회")
    fun `조건절 서브쿼리 예제`() {

    }
}