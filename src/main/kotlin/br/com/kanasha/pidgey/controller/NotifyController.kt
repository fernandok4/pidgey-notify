package br.com.kanasha.pidgey.controller

import br.com.kanasha.pidgey.service.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/notify")
open class NotifyController {

    @Autowired
    private lateinit var notificationService: NotificationService

//    curl --location --request GET 'http://localhost:8080/notify/receive' --header 'Content-Type: text/event-stream'
    @GetMapping("/receive", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun stream(): Flux<String> {
        return notificationService.receiveNotifications()
    }
}