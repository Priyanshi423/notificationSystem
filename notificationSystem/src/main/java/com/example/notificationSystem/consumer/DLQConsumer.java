package com.example.notificationSystem.consumer;

import com.example.notificationSystem.dto.NotificationEvent;
import com.example.notificationSystem.repository.NotificationRepository;
import com.example.notificationSystem.service.NotificationServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DLQConsumer {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationServic notificationServic;

    @KafkaListener(topics = "notification-dlq2", groupId = "dlq-group-neww")
    public void consume(NotificationEvent notificationEvent) {
      notificationServic.markdlq(notificationEvent);
    }
}
