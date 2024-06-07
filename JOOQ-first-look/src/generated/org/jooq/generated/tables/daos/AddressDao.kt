/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.generated.tables.KAddress
import org.jooq.generated.tables.pojos.Address
import org.jooq.generated.tables.records.AddressRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AddressDao(configuration: Configuration?) : DAOImpl<AddressRecord, Address, Long>(KAddress.ADDRESS, Address::class.java, configuration) {

    /**
     * Create a new AddressDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: Address): Long? = o.addressId

    /**
     * Fetch records that have <code>address_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKAddressId(lowerInclusive: Long?, upperInclusive: Long?): List<Address> = fetchRange(KAddress.ADDRESS.ADDRESS_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address_id IN (values)</code>
     */
    fun fetchByKAddressId(vararg values: Long): List<Address> = fetch(KAddress.ADDRESS.ADDRESS_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>address_id = value</code>
     */
    fun fetchOneByKAddressId(value: Long): Address? = fetchOne(KAddress.ADDRESS.ADDRESS_ID, value)

    /**
     * Fetch records that have <code>address BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKAddress(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(KAddress.ADDRESS.ADDRESS_, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    fun fetchByKAddress(vararg values: String): List<Address> = fetch(KAddress.ADDRESS.ADDRESS_, *values)

    /**
     * Fetch records that have <code>address2 BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKAddress2(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(KAddress.ADDRESS.ADDRESS2, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address2 IN (values)</code>
     */
    fun fetchByKAddress2(vararg values: String): List<Address> = fetch(KAddress.ADDRESS.ADDRESS2, *values)

    /**
     * Fetch records that have <code>district BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKDistrict(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(KAddress.ADDRESS.DISTRICT, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>district IN (values)</code>
     */
    fun fetchByKDistrict(vararg values: String): List<Address> = fetch(KAddress.ADDRESS.DISTRICT, *values)

    /**
     * Fetch records that have <code>city_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKCityId(lowerInclusive: Long?, upperInclusive: Long?): List<Address> = fetchRange(KAddress.ADDRESS.CITY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>city_id IN (values)</code>
     */
    fun fetchByKCityId(vararg values: Long): List<Address> = fetch(KAddress.ADDRESS.CITY_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>postal_code BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKPostalCode(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(KAddress.ADDRESS.POSTAL_CODE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>postal_code IN (values)</code>
     */
    fun fetchByKPostalCode(vararg values: String): List<Address> = fetch(KAddress.ADDRESS.POSTAL_CODE, *values)

    /**
     * Fetch records that have <code>phone BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKPhone(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(KAddress.ADDRESS.PHONE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    fun fetchByKPhone(vararg values: String): List<Address> = fetch(KAddress.ADDRESS.PHONE, *values)

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKLastUpdate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<Address> = fetchRange(KAddress.ADDRESS.LAST_UPDATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    fun fetchByKLastUpdate(vararg values: LocalDateTime): List<Address> = fetch(KAddress.ADDRESS.LAST_UPDATE, *values)
}