package br.com.kanasha.pidgey

import br.com.kanasha.pidgey.producer.NotifyProducer
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProducerTest {

    @Autowired
    private lateinit var notifyProducer: NotifyProducer

    @Test
    fun sendMessage(){
        notifyProducer.sendMessage()
    }
}