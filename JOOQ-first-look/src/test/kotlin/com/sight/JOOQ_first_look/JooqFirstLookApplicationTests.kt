package com.sight.JOOQ_first_look

import org.jooq.DSLContext
import org.jooq.generated.tables.KActor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqFirstLookApplicationTests(
		@Autowired private val dslContext: DSLContext
) {
	@Test
	fun contextLoads() {
		val fetch = dslContext.selectFrom(KActor.ACTOR)
				.limit(10)
				.fetch()
		println(fetch)
	}

}
