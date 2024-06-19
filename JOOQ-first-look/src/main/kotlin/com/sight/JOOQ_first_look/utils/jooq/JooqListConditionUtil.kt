package com.sight.JOOQ_first_look.utils.jooq

import org.jooq.Condition
import org.jooq.Field
import org.jooq.impl.DSL

object JooqListConditionUtil {

    fun <T> inIfNotEmpty(field: Field<T?>, fieldList: List<T>): Condition {
        if (fieldList.isEmpty()) {
            return DSL.noCondition()
        }
        return field.`in`(fieldList)
    }
}