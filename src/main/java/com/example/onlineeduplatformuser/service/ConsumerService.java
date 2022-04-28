package com.example.onlineeduplatformuser.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(topics = "user-topic", groupId = "user-topic")
    public void ConsumerService(String message) {
        log.info(String.format("#### -> Consumed message -> %s", message));
    }

}
