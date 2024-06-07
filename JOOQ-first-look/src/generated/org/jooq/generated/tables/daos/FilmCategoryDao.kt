/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.Record2
import org.jooq.generated.tables.KFilmCategory
import org.jooq.generated.tables.pojos.FilmCategory
import org.jooq.generated.tables.records.FilmCategoryRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class FilmCategoryDao(configuration: Configuration?) : DAOImpl<FilmCategoryRecord, FilmCategory, Record2<Long?, Long?>>(KFilmCategory.FILM_CATEGORY, FilmCategory::class.java, configuration) {

    /**
     * Create a new FilmCategoryDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: FilmCategory): Record2<Long?, Long?> = compositeKeyRecord(o.filmId, o.categoryId)

    /**
     * Fetch records that have <code>film_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKFilmId(lowerInclusive: Long?, upperInclusive: Long?): List<FilmCategory> = fetchRange(KFilmCategory.FILM_CATEGORY.FILM_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>film_id IN (values)</code>
     */
    fun fetchByKFilmId(vararg values: Long): List<FilmCategory> = fetch(KFilmCategory.FILM_CATEGORY.FILM_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>category_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKCategoryId(lowerInclusive: Long?, upperInclusive: Long?): List<FilmCategory> = fetchRange(KFilmCategory.FILM_CATEGORY.CATEGORY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>category_id IN (values)</code>
     */
    fun fetchByKCategoryId(vararg values: Long): List<FilmCategory> = fetch(KFilmCategory.FILM_CATEGORY.CATEGORY_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKLastUpdate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<FilmCategory> = fetchRange(KFilmCategory.FILM_CATEGORY.LAST_UPDATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    fun fetchByKLastUpdate(vararg values: LocalDateTime): List<FilmCategory> = fetch(KFilmCategory.FILM_CATEGORY.LAST_UPDATE, *values)
}
