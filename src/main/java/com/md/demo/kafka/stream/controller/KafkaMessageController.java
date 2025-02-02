package com.md.demo.kafka.stream.controller;

import com.md.demo.kafka.stream.kafka.producer.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaMessageController {
    private final KafkaProducerService kafkaProducerService;

    public KafkaMessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Topic");
    }
}
