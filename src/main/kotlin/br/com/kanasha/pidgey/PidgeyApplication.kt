package br.com.kanasha.pidgey

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
open class PidgeyApplication

fun main() {
    SpringApplication.run(PidgeyApplication::class.java)
}