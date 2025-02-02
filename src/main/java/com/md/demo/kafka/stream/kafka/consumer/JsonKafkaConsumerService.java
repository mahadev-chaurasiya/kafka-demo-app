package com.md.demo.kafka.stream.kafka.consumer;

import com.md.demo.kafka.stream.model.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);
    @KafkaListener(topics = "EVENT_JSON_TOPIC", groupId = "devGroup")
    public void consumeKafkaEvent(EventModel message){
        LOGGER.info(String.format("JSON Message received -> %s", message.toString()));

    }
}
