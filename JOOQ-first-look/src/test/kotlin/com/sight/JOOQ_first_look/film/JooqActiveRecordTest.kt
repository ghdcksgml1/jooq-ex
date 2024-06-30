package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.actor.ActorRepository
import org.assertj.core.api.Assertions.assertThat
import org.jooq.DSLContext
import org.jooq.generated.tables.references.ACTOR
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class JooqActiveRecordTest(
    @Autowired private val actorRepository: ActorRepository,
    @Autowired private val dslContext: DSLContext
) {
    @Test
    fun `SELECT 절 예제 - activeRecord 조회`() {
        // given
        val actorId = 1L

        // when
        val actorRecord = actorRepository.findRecordByActorId(actorId)

        // then
        assertThat(actorRecord).hasNoNullFieldsOrProperties()
    }

    @Test
    fun `activeRecord refresh 예제`() {
        // given
        val actorId = 1L
        val actorRecord = actorRepository.findRecordByActorId(actorId) ?: throw IllegalArgumentException()
        actorRecord.firstName = null

        // when
        actorRecord.refresh(ACTOR.FIRST_NAME)

        // then
        assertThat(actorRecord.firstName).isNotBlank()
    }

    @Test
    @Transactional
    fun `activeRecord store 예제 - insert`() {
        // given
        val actorRecord = dslContext.newRecord(ACTOR)

        // when
        actorRecord.firstName = "John"
        actorRecord.lastName = "doe"
        actorRecord.store()
        actorRecord.refresh()

        // then
        assertThat(actorRecord.lastUpdate).isNotNull()
    }

    @Test
    @Transactional
    fun `activeRecord store 예제 - update`() {
        // given
        val actorId = 1L
        val newName = "test"
        val actor = actorRepository.findRecordByActorId(actorId) ?: throw IllegalArgumentException()

        // when
        actor.firstName = newName
        actor.store()

        // then
        assertThat(actor.firstName).isEqualTo(newName)
    }

    @Test
    @Transactional
    fun `activeRecord delete 예제`() {
        // given
        val actorRecord = dslContext.newRecord(ACTOR)
        actorRecord.firstName = "John"
        actorRecord.lastName = "doe"
        actorRecord.store()

        // when
        val result = actorRecord.delete()

        // then
        assertThat(result).isEqualTo(1)
    }
}