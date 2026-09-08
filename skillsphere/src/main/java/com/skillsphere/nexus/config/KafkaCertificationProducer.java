package com.skillsphere.nexus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaCertificationProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendRenewalEvent(String message) {
        kafkaTemplate.send("certification-renewal", message);
    }
}