package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public KafkaConsumer(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @KafkaListener(topics = "${general.kafka-topic}")
    public void listen(Transaction transaction) {
        // Correcting the Optional issue with .orElse(null)
        UserRecord sender = userRepository.findById(transaction.getSenderId()).orElse(null);
        UserRecord recipient = userRepository.findById(transaction.getRecipientId()).orElse(null);

        if (sender != null && recipient != null && sender.getBalance() >= transaction.getAmount()) {
            sender.setBalance(sender.getBalance() - transaction.getAmount());
            recipient.setBalance(recipient.getBalance() + transaction.getAmount());

            userRepository.save(sender);
            userRepository.save(recipient);
            
            TransactionRecord record = new TransactionRecord(sender, recipient, transaction.getAmount());
            transactionRepository.save(record);
            
            System.out.println("Transaction Processed: " + sender.getName() + " -> " + recipient.getName() + " : " + transaction.getAmount());

            // Print the balance for Waldorf to get the Task 3 answer
            UserRecord waldorf = userRepository.findByName("waldorf");
            if (waldorf != null) {
                System.out.println("DEBUG: Waldorf Balance is now: " + waldorf.getBalance());
            }
        }
    }
}