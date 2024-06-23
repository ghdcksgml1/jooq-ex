package com.sight.JOOQ_first_look.actor.dto

data class ActorUpdateRequest(
    val firstName: String? = null,
    val lastName: String? = null,
) {
    fun hasNull(): Boolean {
        return firstName == null || lastName == null
    }
}
