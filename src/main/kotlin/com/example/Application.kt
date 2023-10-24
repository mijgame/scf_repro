package com.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.logging.log4j.LogManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.function.context.MessageRoutingCallback
import org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import java.util.function.Function

@SpringBootApplication
open class Application {
    init {
        System.setProperty(ContextFunctionCatalogAutoConfiguration.JSON_MAPPER_PROPERTY, "jackson")
    }

    @Bean
    open fun objectMapper(): ObjectMapper = ObjectMapper()
        .registerKotlinModule()
        .registerModule(JavaTimeModule())


    @Bean
    open fun handleSignal(): Function<Signal, String> {
        return Function { value: Signal ->
            LogManager.getLogger().info(value)
            "I ran"
        }
    }
}