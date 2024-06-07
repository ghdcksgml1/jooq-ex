/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records


import org.jooq.Record1
import org.jooq.generated.tables.KFilmText
import org.jooq.generated.tables.pojos.FilmText
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class FilmTextRecord() : UpdatableRecordImpl<FilmTextRecord>(KFilmText.FILM_TEXT) {

    open var filmId: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var title: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var description: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    /**
     * Create a detached, initialised FilmTextRecord
     */
    constructor(filmId: Int? = null, title: String? = null, description: String? = null): this() {
        this.filmId = filmId
        this.title = title
        this.description = description
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised FilmTextRecord
     */
    constructor(value: FilmText?): this() {
        if (value != null) {
            this.filmId = value.filmId
            this.title = value.title
            this.description = value.description
            resetChangedOnNotNull()
        }
    }
}
