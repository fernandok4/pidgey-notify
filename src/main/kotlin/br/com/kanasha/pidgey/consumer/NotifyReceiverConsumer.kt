package br.com.kanasha.pidgey.consumer

import br.com.kanasha.pidgey.publisher.RequestSink
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
open class NotifyReceiverConsumer {

    @KafkaListener(topics = ["#{@topic.name}"])
    fun handleMessage(){
        println("Recebeu uma mensagem")
        val result = RequestSink.sink.tryEmitNext("Recebeu uma mensagem")
        result
    }
}