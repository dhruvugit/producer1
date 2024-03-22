package com.poc.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class KafkaMessagePublisher {

     //KafkaTemplate abstracts away the low-level details of interacting with
  // Kafka producers, providing a convenient and efficient way to produce messages to Kafka topics
    @Autowired
    private KafkaTemplate<String,Object> template;

    //Intially we wrote template.send("stocksdata", message); and it's return type is completablefuture
    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("inputTopic", message);
        future.whenComplete((result,ex)->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });

    }
}


