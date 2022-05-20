package br.com.kanasha.pidgey.consumer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class NotifyReceiverConfig {
    @Bean
    open fun topic() = Topic()

    class Topic {
        val name: String = System.getenv().getOrDefault("PIDGEY_NOTIFICATION_CONSUMER", "PIDGEY_NOTIFICATION_CONSUMER")
    }
}