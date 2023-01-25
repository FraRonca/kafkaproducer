package it.nttdata.producerkafka.producerkafka.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendMessageService {

    @Autowired
    private NewTopic newTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {

        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, newTopic.name())
                .setHeader(KafkaHeaders.PARTITION_ID, 0)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "key1")
                .build();

        kafkaTemplate.send(message);
    }

    public void sendMessage2(String msg) {
        Message<String> message = MessageBuilder.withPayload(msg)
                .setHeader(KafkaHeaders.TOPIC, newTopic.name())
                .setHeader(KafkaHeaders.PARTITION_ID, 1)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "key2")
                .build();

        kafkaTemplate.send(message);
    }
}
