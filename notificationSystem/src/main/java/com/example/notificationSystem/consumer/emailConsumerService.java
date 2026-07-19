package com.example.notificationSystem.consumer;

import com.example.notificationSystem.dto.NotificationEvent;
import com.example.notificationSystem.repository.NotificationRepository;
import com.example.notificationSystem.services.emailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class emailConsumerService {
    @Autowired
    private emailService emailService;
     @KafkaListener(topics="notification-event",groupId="email-group")
    public void consume(NotificationEvent notificationEvent) throws Exception{
       // Notification  notification = notificationRepository.findByNotificationId(notificationEvent.getNotificationId()).orElseThrow();
         System.out.println("email consumer service");
            emailService.sendEmail("priyanshiagarwal1816@gmail.com", "notification of event ", "hey");
            //notification.setStatus("SENT");
            // notificationRepository.save(notification);
            // logger.info("email sent to "+notificationEvent.getEmail());}


          //  notification.setFailureReason(e.getMessage());
           // notificationRepository.save(notification);



    }
}
