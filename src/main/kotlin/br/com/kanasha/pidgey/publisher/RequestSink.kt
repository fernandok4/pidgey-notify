package br.com.kanasha.pidgey.publisher

import reactor.core.publisher.Sinks

object RequestSink {

    val sink = Sinks.many().multicast().onBackpressureBuffer<String>()
}