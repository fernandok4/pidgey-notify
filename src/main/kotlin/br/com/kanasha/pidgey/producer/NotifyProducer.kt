package br.com.kanasha.pidgey.producer

import br.com.kanasha.pidgey.dto.ConsumerMessageDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
open class NotifyProducer {

    @Value("#{@topic.name}")
    private lateinit var topicName: String
    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, ConsumerMessageDTO>

    fun sendMessage(){
        kafkaTemplate.send(topicName, ConsumerMessageDTO("2", "{\"cdStock\":\"VALE3\"}"))
    }
}