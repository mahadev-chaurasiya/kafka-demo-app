package com.md.demo.kafka.stream.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topicBuilder(){
        return TopicBuilder.name("EVENT_TOPIC").build();
    }

    @Bean
    public NewTopic topicBuilderJsonTopic(){
        return TopicBuilder.name("EVENT_JSON_TOPIC").build();
    }
}
