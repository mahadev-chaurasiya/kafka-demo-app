package com.md.demo.kafka.stream.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);
    @KafkaListener(topics = "EVENT_TOPIC", groupId = "devGroup")
    public void consumeKafkaEvent(String message){
        LOGGER.info(String.format("Message received -> %s", message));

    }
}
