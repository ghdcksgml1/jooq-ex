package com.sight.JOOQ_first_look.film

import com.sight.JOOQ_first_look.actor.ActorRepository
import com.sight.JOOQ_first_look.actor.dto.ActorUpdateRequest
import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Actor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class JooqUpdateTest(
    @Autowired private val actorRepository: ActorRepository
) {
    @Test
    fun `pojo를 사용한 update`() {
        // given
        val newActor = Actor()
        newActor.firstName = "Tom"
        newActor.lastName = "Cruise"
        newActor.lastUpdate = LocalDateTime.now()

        val actor = actorRepository.saveWithReturning(newActor) ?: throw IllegalArgumentException()

        // when
        actor.firstName = "Suri"
        actorRepository.update(actor)

        // then
        val updatedActor = actorRepository.findByActorId(actor.actorId!!)
        Assertions.assertThat(updatedActor!!.firstName).isEqualTo("Suri")
    }

    @Test
    fun `일부 필드만 update - DTO 활용`() {
        val newActor = Actor()
        newActor.firstName = "Tom"
        newActor.lastName = "Cruise"
        newActor.lastUpdate = LocalDateTime.now()

        val newActorId = actorRepository.saveWithReturningId(newActor) ?: throw IllegalArgumentException()
        val request = ActorUpdateRequest(firstName = "Suri")

        // when
        actorRepository.updateWithDto(newActorId, request)

        // then
        val updatedActor = actorRepository.findByActorId(newActorId)
        Assertions.assertThat(updatedActor!!.firstName).isEqualTo("Suri")
    }

    @Test
    fun `일부 필드만 update - DTO 활용 - with record`() {
        val newActor = Actor()
        newActor.firstName = "Tom"
        newActor.lastName = "Cruise"
        newActor.lastUpdate = LocalDateTime.now()

        val newActorId = actorRepository.saveWithReturningId(newActor) ?: throw IllegalArgumentException()
        val request = ActorUpdateRequest(firstName = "Suri")

        // when
        actorRepository.updateWithRecord(newActorId, request)

        // then
        val updatedActor = actorRepository.findByActorId(newActorId)
        Assertions.assertThat(updatedActor!!.firstName).isEqualTo("Suri")
    }

    @Test
    fun `delete 예제`() {
        // given
        val newActor = Actor()
        newActor.firstName = "Tom"
        newActor.lastName = "Cruise"

        val newActorId = actorRepository.saveWithReturningId(newActor)

        // when
        val result: Int = actorRepository.delete(newActorId!!)

        // then
        Assertions.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `delete 예제 - with active record`() {
        // given
        val newActor = Actor()
        newActor.firstName = "Tom"
        newActor.lastName = "Cruise"
        newActor.lastUpdate = LocalDateTime.now()

        val actor = actorRepository.saveWithReturning(newActor)

        // when
        val result = actorRepository.deleteWithRecord(actor!!)

        // then
        Assertions.assertThat(result).isEqualTo(1)
    }
}