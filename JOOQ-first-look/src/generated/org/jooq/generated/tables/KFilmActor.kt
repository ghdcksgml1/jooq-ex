/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables


import java.time.LocalDateTime

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Index
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.generated.KSakila
import org.jooq.generated.indexes.FILM_ACTOR_IDX_FK_FILM_ID
import org.jooq.generated.keys.FK_FILM_ACTOR_ACTOR
import org.jooq.generated.keys.FK_FILM_ACTOR_FILM
import org.jooq.generated.keys.KEY_FILM_ACTOR_PRIMARY
import org.jooq.generated.tables.KActor.ActorPath
import org.jooq.generated.tables.KFilm.FilmPath
import org.jooq.generated.tables.records.FilmActorRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class KFilmActor(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, FilmActorRecord>?,
    parentPath: InverseForeignKey<out Record, FilmActorRecord>?,
    aliased: Table<FilmActorRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<FilmActorRecord>(
    alias,
    KSakila.SAKILA,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>sakila.film_actor</code>
         */
        val FILM_ACTOR: KFilmActor = KFilmActor()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<FilmActorRecord> = FilmActorRecord::class.java

    /**
     * The column <code>sakila.film_actor.actor_id</code>.
     */
    val ACTOR_ID: TableField<FilmActorRecord, Long?> = createField(DSL.name("actor_id"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "", AutoConverter<UInteger, Long>(UInteger::class.java, Long::class.java))

    /**
     * The column <code>sakila.film_actor.film_id</code>.
     */
    val FILM_ID: TableField<FilmActorRecord, Long?> = createField(DSL.name("film_id"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "", AutoConverter<UInteger, Long>(UInteger::class.java, Long::class.java))

    /**
     * The column <code>sakila.film_actor.last_update</code>.
     */
    val LAST_UPDATE: TableField<FilmActorRecord, LocalDateTime?> = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "")

    private constructor(alias: Name, aliased: Table<FilmActorRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<FilmActorRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<FilmActorRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>sakila.film_actor</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>sakila.film_actor</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>sakila.film_actor</code> table reference
     */
    constructor(): this(DSL.name("film_actor"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, FilmActorRecord>?, parentPath: InverseForeignKey<out Record, FilmActorRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, FILM_ACTOR, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class FilmActorPath : KFilmActor, Path<FilmActorRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, FilmActorRecord>?, parentPath: InverseForeignKey<out Record, FilmActorRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<FilmActorRecord>): super(alias, aliased)
        override fun `as`(alias: String): FilmActorPath = FilmActorPath(DSL.name(alias), this)
        override fun `as`(alias: Name): FilmActorPath = FilmActorPath(alias, this)
        override fun `as`(alias: Table<*>): FilmActorPath = FilmActorPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else KSakila.SAKILA
    override fun getIndexes(): List<Index> = listOf(FILM_ACTOR_IDX_FK_FILM_ID)
    override fun getPrimaryKey(): UniqueKey<FilmActorRecord> = KEY_FILM_ACTOR_PRIMARY
    override fun getReferences(): List<ForeignKey<FilmActorRecord, *>> = listOf(FK_FILM_ACTOR_ACTOR, FK_FILM_ACTOR_FILM)

    private lateinit var _actor: ActorPath

    /**
     * Get the implicit join path to the <code>sakila.actor</code> table.
     */
    fun actor(): ActorPath {
        if (!this::_actor.isInitialized)
            _actor = ActorPath(this, FK_FILM_ACTOR_ACTOR, null)

        return _actor;
    }

    val actor: ActorPath
        get(): ActorPath = actor()

    private lateinit var _film: FilmPath

    /**
     * Get the implicit join path to the <code>sakila.film</code> table.
     */
    fun film(): FilmPath {
        if (!this::_film.isInitialized)
            _film = FilmPath(this, FK_FILM_ACTOR_FILM, null)

        return _film;
    }

    val film: FilmPath
        get(): FilmPath = film()
    override fun `as`(alias: String): KFilmActor = KFilmActor(DSL.name(alias), this)
    override fun `as`(alias: Name): KFilmActor = KFilmActor(alias, this)
    override fun `as`(alias: Table<*>): KFilmActor = KFilmActor(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): KFilmActor = KFilmActor(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): KFilmActor = KFilmActor(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): KFilmActor = KFilmActor(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): KFilmActor = KFilmActor(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): KFilmActor = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): KFilmActor = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): KFilmActor = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): KFilmActor = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): KFilmActor = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): KFilmActor = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): KFilmActor = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): KFilmActor = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): KFilmActor = where(DSL.notExists(select))
}
