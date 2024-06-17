package com.sight.JOOQ_first_look.web

data class PagedResponse(
        val page: Long,
        val pageSize: Long
)