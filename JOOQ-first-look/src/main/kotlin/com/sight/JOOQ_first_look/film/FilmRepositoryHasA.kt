package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.film.dto.*
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.DatePart
import org.jooq.generated.tables.daos.FilmDao
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.references.*
import org.jooq.impl.DSL
import org.jooq.impl.DSL.*
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class FilmRepositoryHasA(
        configuration: Configuration,
        private val dslContext: DSLContext,
) : FilmDao(configuration = configuration) {
    override fun findById(id: Long): Film? {
        return dslContext.select(FILM)
                .from(FILM)
                .where(FILM.FILM_ID.eq(id))
                .fetchOneInto(Film::class.java)
    }

    fun findByRangeBetween(from: Int, to: Int): List<Film> {
        return fetchRangeOfKLength(from, to)
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

    fun findFilmPriceSummaryByFilmTitle(filmTitle: String): List<FilmPriceSummary> {

        return dslContext.select(
                FILM.FILM_ID,
                FILM.TITLE,
                FILM.RENTAL_RATE,
                case_()
                        .`when`(FILM.RENTAL_RATE.le(BigDecimal.valueOf(1.0)), PriceCategory.CHEAP.code)
                        .`when`(FILM.RENTAL_RATE.le(BigDecimal.valueOf(3.0)), PriceCategory.MODERATE.code)
                        .else_(PriceCategory.EXPENSIVE.code)
                        .`as`(FilmPriceSummary::priceCategory.name).convert(PriceCategoryConverter()),
                selectCount().from(INVENTORY).where(INVENTORY.FILM_ID.eq(FILM.FILM_ID)).asField<Int>(FilmPriceSummary::totalInventory.name)
        )
                .from(FILM)
                .where(FILM.TITLE.likeRegex(filmTitle))
                .fetchInto(FilmPriceSummary::class.java)
    }

    fun findFilmRentalSummaryByFilmTitle(filmTitle: String): List<FilmRentalSummary> {
        val rentalDurationInfoSubquery = select(
                INVENTORY.FILM_ID,
                avg(localDateTimeDiff(DatePart.DAY, RENTAL.RENTAL_DATE, RENTAL.RETURN_DATE))
                        .`as`(FilmRentalSummary::averageRentalDuration.name)
        )
                .from(RENTAL)
                .join(INVENTORY).on(INVENTORY.INVENTORY_ID.eq(RENTAL.INVENTORY_ID))
                .where(RENTAL.RETURN_DATE.isNotNull)
                .groupBy(INVENTORY.FILM_ID)
                .asTable("rental_duration_info")

        return dslContext.select(
                FILM.FILM_ID,
                FILM.TITLE,
                rentalDurationInfoSubquery.field(FilmRentalSummary::averageRentalDuration.name)
        )
                .from(FILM)
                .join(rentalDurationInfoSubquery).on(FILM.FILM_ID.eq(rentalDurationInfoSubquery.field(INVENTORY.FILM_ID)))
                .where(FILM.FILM_ID.likeRegex(filmTitle))
                .orderBy(rentalDurationInfoSubquery.field(FilmRentalSummary::averageRentalDuration.name)?.desc())
                .fetchInto(FilmRentalSummary::class.java)
    }

    fun findRentedFilmByTitle(filmTitle: String): List<Film> {
        val existsRentalHistory = selectOne()
                .from(INVENTORY)
                .join(RENTAL).on(RENTAL.INVENTORY_ID.eq(INVENTORY.INVENTORY_ID))
                .where(INVENTORY.FILM_ID.eq(FILM.FILM_ID))

        return dslContext.selectFrom(FILM)
                .where(
                        exists(existsRentalHistory),
                        FILM.TITLE.likeRegex(filmTitle)
                )
                .fetchInto(Film::class.java)
    }
}