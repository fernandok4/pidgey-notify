package br.com.kanasha.pidgey.service

import br.com.kanasha.pidgey.publisher.RequestSink
import br.com.kanasha.pidgey.publisher.RequestSink.sink
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
open class NotificationService {

    fun receiveNotifications(key: String): Flux<String> {
        return (sink[key] ?: RequestSink.createSink(key)).asFlux()
    }
}