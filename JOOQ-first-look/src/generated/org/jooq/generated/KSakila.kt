/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated


import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.generated.tables.KActor
import org.jooq.generated.tables.KAddress
import org.jooq.generated.tables.KCategory
import org.jooq.generated.tables.KCity
import org.jooq.generated.tables.KCountry
import org.jooq.generated.tables.KCustomer
import org.jooq.generated.tables.KFilm
import org.jooq.generated.tables.KFilmActor
import org.jooq.generated.tables.KFilmCategory
import org.jooq.generated.tables.KFilmText
import org.jooq.generated.tables.KInventory
import org.jooq.generated.tables.KLanguage
import org.jooq.generated.tables.KPayment
import org.jooq.generated.tables.KRental
import org.jooq.generated.tables.KStaff
import org.jooq.generated.tables.KStore
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class KSakila : SchemaImpl("sakila", DefaultCatalog.DEFAULT_CATALOG) {
    public companion object {

        /**
         * The reference instance of <code>sakila</code>
         */
        val SAKILA: KSakila = KSakila()
    }

    /**
     * The table <code>sakila.actor</code>.
     */
    val ACTOR: KActor get() = KActor.ACTOR

    /**
     * The table <code>sakila.address</code>.
     */
    val ADDRESS: KAddress get() = KAddress.ADDRESS

    /**
     * The table <code>sakila.category</code>.
     */
    val CATEGORY: KCategory get() = KCategory.CATEGORY

    /**
     * The table <code>sakila.city</code>.
     */
    val CITY: KCity get() = KCity.CITY

    /**
     * The table <code>sakila.country</code>.
     */
    val COUNTRY: KCountry get() = KCountry.COUNTRY

    /**
     * The table <code>sakila.customer</code>.
     */
    val CUSTOMER: KCustomer get() = KCustomer.CUSTOMER

    /**
     * The table <code>sakila.film</code>.
     */
    val FILM: KFilm get() = KFilm.FILM

    /**
     * The table <code>sakila.film_actor</code>.
     */
    val FILM_ACTOR: KFilmActor get() = KFilmActor.FILM_ACTOR

    /**
     * The table <code>sakila.film_category</code>.
     */
    val FILM_CATEGORY: KFilmCategory get() = KFilmCategory.FILM_CATEGORY

    /**
     * The table <code>sakila.film_text</code>.
     */
    val FILM_TEXT: KFilmText get() = KFilmText.FILM_TEXT

    /**
     * The table <code>sakila.inventory</code>.
     */
    val INVENTORY: KInventory get() = KInventory.INVENTORY

    /**
     * The table <code>sakila.language</code>.
     */
    val LANGUAGE: KLanguage get() = KLanguage.LANGUAGE

    /**
     * The table <code>sakila.payment</code>.
     */
    val PAYMENT: KPayment get() = KPayment.PAYMENT

    /**
     * The table <code>sakila.rental</code>.
     */
    val RENTAL: KRental get() = KRental.RENTAL

    /**
     * The table <code>sakila.staff</code>.
     */
    val STAFF: KStaff get() = KStaff.STAFF

    /**
     * The table <code>sakila.store</code>.
     */
    val STORE: KStore get() = KStore.STORE

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        KActor.ACTOR,
        KAddress.ADDRESS,
        KCategory.CATEGORY,
        KCity.CITY,
        KCountry.COUNTRY,
        KCustomer.CUSTOMER,
        KFilm.FILM,
        KFilmActor.FILM_ACTOR,
        KFilmCategory.FILM_CATEGORY,
        KFilmText.FILM_TEXT,
        KInventory.INVENTORY,
        KLanguage.LANGUAGE,
        KPayment.PAYMENT,
        KRental.RENTAL,
        KStaff.STAFF,
        KStore.STORE
    )
}