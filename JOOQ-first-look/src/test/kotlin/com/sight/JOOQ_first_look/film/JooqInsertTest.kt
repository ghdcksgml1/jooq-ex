package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.actor.ActorRepository
import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Actor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class JooqInsertTest(
    @Autowired private val actorRepository: ActorRepository
) {
    @Test
    fun `자동생성된 DAO를 통한 insert`() {
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"
        actor.lastUpdate = LocalDateTime.now()

        // when
        actorRepository.saveByDao(actor)

        // then
        Assertions.assertThat(actor.actorId).isNotNull()
    }

    @Test
    fun `ActiveRecord를 통한 insert`() {
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"
        actor.lastUpdate = LocalDateTime.now()

        // when
        val actorRecord = actorRepository.saveByRecord(actor)

        // then
        Assertions.assertThat(actor.actorId).isNull()
        Assertions.assertThat(actorRecord.actorId).isNotNull()
    }

    @Test
    fun `SQL 실행 후 PK만 반환`() {
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"
        actor.lastUpdate = LocalDateTime.now()

        // when
        val actorId = actorRepository.saveWithReturningId(actor)

        // given
        Assertions.assertThat(actorId).isNotNull()
    }

    @Test
    fun `SQL 실행 후 해당 ROW 반환`() {
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"
        actor.lastUpdate = LocalDateTime.now()

        // when
        val newActor = actorRepository.saveWithReturning(actor)

        // given
        Assertions.assertThat(newActor).hasNoNullFieldsOrProperties()
    }

    @Test
    fun `bulk insert 예제`() {
        // given
        val actor1 = Actor()
        actor1.firstName = "John"
        actor1.lastName = "Doe"
        actor1.lastUpdate = LocalDateTime.now()

        val actor2 = Actor()
        actor2.firstName = "John 2"
        actor2.lastName = "Doe 2"
        actor2.lastUpdate = LocalDateTime.now()

        val actorList = listOf(actor1, actor2)

        // when
        actorRepository.bulkInsertWithRows(actorList)
    }
}