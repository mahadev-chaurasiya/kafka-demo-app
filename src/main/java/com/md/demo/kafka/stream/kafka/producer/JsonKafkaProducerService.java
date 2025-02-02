package com.md.demo.kafka.stream.kafka.producer;

import com.md.demo.kafka.stream.model.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducerService.class);
    private KafkaTemplate<String, EventModel> kafkaTemplate;

    public JsonKafkaProducerService(KafkaTemplate<String, EventModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(EventModel model){
        LOGGER.info(String.format("JSON Message Sent -> %s", model.toString()));
        Message<EventModel> message = MessageBuilder
                .withPayload(model)
                .setHeader(KafkaHeaders.TOPIC,"EVENT_JSON_TOPIC")
                .build();
        kafkaTemplate.send(message);

    }
}
