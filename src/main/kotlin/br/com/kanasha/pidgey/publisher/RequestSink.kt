package br.com.kanasha.pidgey.publisher

import reactor.core.publisher.Sinks
import java.util.*

object RequestSink {

    val sink: MutableMap<String, Sinks.Many<String>> = Collections.synchronizedMap(mutableMapOf())

    fun createSink(key: String): Sinks.Many<String> {
        sink[key] = Sinks.many().multicast().directBestEffort()
        return sink[key]!!
    }
}