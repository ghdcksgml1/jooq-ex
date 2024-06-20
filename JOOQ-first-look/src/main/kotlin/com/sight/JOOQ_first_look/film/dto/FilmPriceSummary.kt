package com.sight.JOOQ_first_look.film.dto

import java.math.BigDecimal

data class FilmPriceSummary(
        val filmId: Long?,
        val title: String?,
        val rentalRate: BigDecimal?,
        val priceCategory: PriceCategory?,
        val totalInventory: Long?
)