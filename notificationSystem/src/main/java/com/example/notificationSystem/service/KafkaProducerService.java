package com.example.notificationSystem.service;

import com.example.notificationSystem.dto.NotificationEvent;
import com.example.notificationSystem.entity.Notification;
import com.example.notificationSystem.model.NotificationStatus;
import com.example.notificationSystem.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String,NotificationEvent> kafkaTemplate;
    @Autowired
    private NotificationRepository notificationRepository;
    public void sendMessage(NotificationEvent event){

        kafkaTemplate.send("notification-event",event);
    }
}
