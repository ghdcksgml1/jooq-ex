package com.sight.JOOQ_first_look.config

import org.jooq.conf.ExecuteWithoutWhere
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JooqConfig {

    @Bean
    fun jooqDefaultConfigurationCustomizer(): DefaultConfigurationCustomizer = DefaultConfigurationCustomizer {
        it.settings()
            .withExecuteUpdateWithoutWhere(ExecuteWithoutWhere.THROW)
            .withExecuteDeleteWithoutWhere(ExecuteWithoutWhere.THROW)
            .withRenderSchema(false)
    }
}