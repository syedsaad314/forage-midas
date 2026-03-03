package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    @Value("${general.kafka-topic}")
    private String topic;

    public KafkaProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Transaction transaction) {
        kafkaTemplate.send(topic, transaction);
    }
}