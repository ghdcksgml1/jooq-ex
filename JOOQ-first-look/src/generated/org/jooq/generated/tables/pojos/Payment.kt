/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos


import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Payment(
    var paymentId: Long? = null,
    var customerId: Long? = null,
    var staffId: Long? = null,
    var rentalId: Int? = null,
    var amount: BigDecimal? = null,
    var paymentDate: LocalDateTime? = null,
    var lastUpdate: LocalDateTime? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Payment = other as Payment
        if (this.paymentId == null) {
            if (o.paymentId != null)
                return false
        }
        else if (this.paymentId != o.paymentId)
            return false
        if (this.customerId == null) {
            if (o.customerId != null)
                return false
        }
        else if (this.customerId != o.customerId)
            return false
        if (this.staffId == null) {
            if (o.staffId != null)
                return false
        }
        else if (this.staffId != o.staffId)
            return false
        if (this.rentalId == null) {
            if (o.rentalId != null)
                return false
        }
        else if (this.rentalId != o.rentalId)
            return false
        if (this.amount == null) {
            if (o.amount != null)
                return false
        }
        else if (this.amount != o.amount)
            return false
        if (this.paymentDate == null) {
            if (o.paymentDate != null)
                return false
        }
        else if (this.paymentDate != o.paymentDate)
            return false
        if (this.lastUpdate == null) {
            if (o.lastUpdate != null)
                return false
        }
        else if (this.lastUpdate != o.lastUpdate)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.paymentId == null) 0 else this.paymentId.hashCode())
        result = prime * result + (if (this.customerId == null) 0 else this.customerId.hashCode())
        result = prime * result + (if (this.staffId == null) 0 else this.staffId.hashCode())
        result = prime * result + (if (this.rentalId == null) 0 else this.rentalId.hashCode())
        result = prime * result + (if (this.amount == null) 0 else this.amount.hashCode())
        result = prime * result + (if (this.paymentDate == null) 0 else this.paymentDate.hashCode())
        result = prime * result + (if (this.lastUpdate == null) 0 else this.lastUpdate.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Payment (")

        sb.append(paymentId)
        sb.append(", ").append(customerId)
        sb.append(", ").append(staffId)
        sb.append(", ").append(rentalId)
        sb.append(", ").append(amount)
        sb.append(", ").append(paymentDate)
        sb.append(", ").append(lastUpdate)

        sb.append(")")
        return sb.toString()
    }
}
