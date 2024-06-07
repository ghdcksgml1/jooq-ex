/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records


import java.time.LocalDateTime

import org.jooq.Record1
import org.jooq.generated.tables.KLanguage
import org.jooq.generated.tables.pojos.Language
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class LanguageRecord() : UpdatableRecordImpl<LanguageRecord>(KLanguage.LANGUAGE) {

    open var languageId: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var name: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var lastUpdate: LocalDateTime?
        set(value): Unit = set(2, value)
        get(): LocalDateTime? = get(2) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    /**
     * Create a detached, initialised LanguageRecord
     */
    constructor(languageId: Long? = null, name: String? = null, lastUpdate: LocalDateTime? = null): this() {
        this.languageId = languageId
        this.name = name
        this.lastUpdate = lastUpdate
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised LanguageRecord
     */
    constructor(value: Language?): this() {
        if (value != null) {
            this.languageId = value.languageId
            this.name = value.name
            this.lastUpdate = value.lastUpdate
            resetChangedOnNotNull()
        }
    }
}
