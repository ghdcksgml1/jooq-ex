package com.sight.JOOQ_first_look.film.dto

import org.jooq.impl.EnumConverter

enum class PriceCategory(val code: String) {
    CHEAP("Cheap"),
    MODERATE("Moderate"),
    EXPENSIVE("Expensive");
}

class PriceCategoryConverter : EnumConverter<String, PriceCategory>(String::class.java, PriceCategory::class.java, PriceCategory::code)