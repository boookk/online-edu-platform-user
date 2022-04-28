package com.example.onlineeduplatformuser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerService {

    private static final String TOPIC = "user-topic";

    @Autowired
    private KafkaTemplate<Object, String> kafkaTemplate;

    public void sendMessage(String email, String password) {
        this.kafkaTemplate.send(TOPIC, email + ' ' + password);
    }

}
