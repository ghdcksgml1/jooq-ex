/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import java.math.BigDecimal
import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.generated.tables.KPayment
import org.jooq.generated.tables.pojos.Payment
import org.jooq.generated.tables.records.PaymentRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class PaymentDao(configuration: Configuration?) : DAOImpl<PaymentRecord, Payment, Long>(KPayment.PAYMENT, Payment::class.java, configuration) {

    /**
     * Create a new PaymentDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: Payment): Long? = o.paymentId

    /**
     * Fetch records that have <code>payment_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKPaymentId(lowerInclusive: Long?, upperInclusive: Long?): List<Payment> = fetchRange(KPayment.PAYMENT.PAYMENT_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>payment_id IN (values)</code>
     */
    fun fetchByKPaymentId(vararg values: Long): List<Payment> = fetch(KPayment.PAYMENT.PAYMENT_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>payment_id = value</code>
     */
    fun fetchOneByKPaymentId(value: Long): Payment? = fetchOne(KPayment.PAYMENT.PAYMENT_ID, value)

    /**
     * Fetch records that have <code>customer_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKCustomerId(lowerInclusive: Long?, upperInclusive: Long?): List<Payment> = fetchRange(KPayment.PAYMENT.CUSTOMER_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>customer_id IN (values)</code>
     */
    fun fetchByKCustomerId(vararg values: Long): List<Payment> = fetch(KPayment.PAYMENT.CUSTOMER_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>staff_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKStaffId(lowerInclusive: Long?, upperInclusive: Long?): List<Payment> = fetchRange(KPayment.PAYMENT.STAFF_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>staff_id IN (values)</code>
     */
    fun fetchByKStaffId(vararg values: Long): List<Payment> = fetch(KPayment.PAYMENT.STAFF_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>rental_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKRentalId(lowerInclusive: Int?, upperInclusive: Int?): List<Payment> = fetchRange(KPayment.PAYMENT.RENTAL_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>rental_id IN (values)</code>
     */
    fun fetchByKRentalId(vararg values: Int): List<Payment> = fetch(KPayment.PAYMENT.RENTAL_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>amount BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKAmount(lowerInclusive: BigDecimal?, upperInclusive: BigDecimal?): List<Payment> = fetchRange(KPayment.PAYMENT.AMOUNT, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>amount IN (values)</code>
     */
    fun fetchByKAmount(vararg values: BigDecimal): List<Payment> = fetch(KPayment.PAYMENT.AMOUNT, *values)

    /**
     * Fetch records that have <code>payment_date BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKPaymentDate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<Payment> = fetchRange(KPayment.PAYMENT.PAYMENT_DATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>payment_date IN (values)</code>
     */
    fun fetchByKPaymentDate(vararg values: LocalDateTime): List<Payment> = fetch(KPayment.PAYMENT.PAYMENT_DATE, *values)

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfKLastUpdate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<Payment> = fetchRange(KPayment.PAYMENT.LAST_UPDATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    fun fetchByKLastUpdate(vararg values: LocalDateTime): List<Payment> = fetch(KPayment.PAYMENT.LAST_UPDATE, *values)
}
