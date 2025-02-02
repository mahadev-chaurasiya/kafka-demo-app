package com.md.demo.kafka.stream.controller;

import com.md.demo.kafka.stream.kafka.producer.JsonKafkaProducerService;
import com.md.demo.kafka.stream.model.EventModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonKafkaMessageController {
    private JsonKafkaProducerService kafkaProducerService;

    public JsonKafkaMessageController(JsonKafkaProducerService jsonKafkaProducerService) {
        this.kafkaProducerService = jsonKafkaProducerService;
    }

    @PostMapping("/publish2")
    public ResponseEntity<String> publish(@RequestBody EventModel eventModel){
        kafkaProducerService.sendMessage(eventModel);
        return ResponseEntity.ok("JSON Message sent to Kafka Topic");
    }

}
