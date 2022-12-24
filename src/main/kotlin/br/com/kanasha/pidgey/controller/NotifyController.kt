package br.com.kanasha.pidgey.controller

import br.com.kanasha.pidgey.dto.SubscribeBodyDTO
import br.com.kanasha.pidgey.service.NotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/notify")
open class NotifyController {

    @Autowired
    private lateinit var notificationService: NotificationService

    @PostMapping("/subscribe", produces = [MediaType.TEXT_EVENT_STREAM_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun subscribe(@RequestBody subscribeBodyDTO: SubscribeBodyDTO): Flux<String> {
        return notificationService.receiveNotifications(subscribeBodyDTO.key)
    }
}