package br.com.kanasha.pidgey.consumer

import br.com.kanasha.pidgey.publisher.RequestSink
import br.com.kanasha.pidgey.dto.ConsumerMessageDTO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
open class NotifyReceiverConsumer {

    @KafkaListener(topics = ["#{@topic.name}"])
    fun handleMessage(message: ConsumerMessageDTO){
        println("Recebeu uma mensagem: " + message.json)
        RequestSink.sink[message.key]?.tryEmitNext(message.json)
    }
}