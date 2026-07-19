//package com.example.notificationSystem.consumer;
//
//import com.example.notificationSystem.dto.NotificationEvent;
//import com.example.notificationSystem.entity.Notification;
//import com.example.notificationSystem.repository.NotificationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.OffsetDateTime;
//
//@Service
//public class dbConsumerService {
//    @Autowired
//    NotificationRepository notificationRepository;
//    @KafkaListener(topics="notification-events",groupId="db-group")
//    public String consume(NotificationEvent event){
//        Notification notification=new Notification();
//        notification.setUserId(event.getUserId());
//        notification.setEmail(event.getEmail());
//        notification.setMessage(event.getMessage());
//        notification.setStatus("RECEIVED");
//        notification.setRetryCount(0);
//        notification.setNotificationId(event.getNotificationId());
//        notification.setCreatedAt(OffsetDateTime.now());
//        notification.setUpdatedAt(OffsetDateTime.now());
//
//
//        notificationRepository.save(notification);
//
//        return "saved  successfully";
//    }
//}
