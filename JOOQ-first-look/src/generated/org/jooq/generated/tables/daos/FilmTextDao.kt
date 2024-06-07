/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.generated.tables.KFilmText
import org.jooq.generated.tables.pojos.FilmText
import org.jooq.generated.tables.records.FilmTextRecord
import org.jooq.impl.DAOImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class FilmTextDao(configuration: Configuration?) : DAOImpl<FilmTextRecord, FilmText, Int>(KFilmText.FILM_TEXT, FilmText::class.java, configuration) {

    /**
     * Create a new FilmTextDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: FilmText): Int? = o.filmId

    /**
     * Fetch records that have <code>film_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKFilmId(lowerInclusive: Int?, upperInclusive: Int?): List<FilmText> = fetchRange(KFilmText.FILM_TEXT.FILM_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>film_id IN (values)</code>
     */
    fun fetchByKFilmId(vararg values: Int): List<FilmText> = fetch(KFilmText.FILM_TEXT.FILM_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>film_id = value</code>
     */
    fun fetchOneByKFilmId(value: Int): FilmText? = fetchOne(KFilmText.FILM_TEXT.FILM_ID, value)

    /**
     * Fetch records that have <code>title BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKTitle(lowerInclusive: String?, upperInclusive: String?): List<FilmText> = fetchRange(KFilmText.FILM_TEXT.TITLE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    fun fetchByKTitle(vararg values: String): List<FilmText> = fetch(KFilmText.FILM_TEXT.TITLE, *values)

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKDescription(lowerInclusive: String?, upperInclusive: String?): List<FilmText> = fetchRange(KFilmText.FILM_TEXT.DESCRIPTION, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    fun fetchByKDescription(vararg values: String): List<FilmText> = fetch(KFilmText.FILM_TEXT.DESCRIPTION, *values)
}