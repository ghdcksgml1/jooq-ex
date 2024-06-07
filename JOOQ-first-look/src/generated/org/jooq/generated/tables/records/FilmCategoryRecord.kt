/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records


import java.time.LocalDateTime

import org.jooq.Record2
import org.jooq.generated.tables.KFilmCategory
import org.jooq.generated.tables.pojos.FilmCategory
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class FilmCategoryRecord() : UpdatableRecordImpl<FilmCategoryRecord>(KFilmCategory.FILM_CATEGORY) {

    open var filmId: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var categoryId: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    open var lastUpdate: LocalDateTime?
        set(value): Unit = set(2, value)
        get(): LocalDateTime? = get(2) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record2<Long?, Long?> = super.key() as Record2<Long?, Long?>

    /**
     * Create a detached, initialised FilmCategoryRecord
     */
    constructor(filmId: Long? = null, categoryId: Long? = null, lastUpdate: LocalDateTime? = null): this() {
        this.filmId = filmId
        this.categoryId = categoryId
        this.lastUpdate = lastUpdate
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised FilmCategoryRecord
     */
    constructor(value: FilmCategory?): this() {
        if (value != null) {
            this.filmId = value.filmId
            this.categoryId = value.categoryId
            this.lastUpdate = value.lastUpdate
            resetChangedOnNotNull()
        }
    }
}
