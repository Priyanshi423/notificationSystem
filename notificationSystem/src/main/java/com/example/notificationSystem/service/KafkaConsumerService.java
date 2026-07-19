/*
package com.example.notificationSystem.service;

import com.example.notificationSystem.dto.NotificationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics="notification",groupId="notification-group")

        public void consume(NotificationEvent event) {

            System.out.println("User Id: " + event.getUserId());
            System.out.println("Email: " + event.getEmail());
            System.out.println("Message: " + event.getMessage());

    }
}
*/
