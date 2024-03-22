package com.poc.kafkaproducer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic topicStreamed(){
        return new NewTopic("inputTopic", 1, (short) 1);
    }
    @Bean
    public NewTopic createTopic(){
        return new NewTopic("outputTopic", 1, (short) 1);
    }

}
