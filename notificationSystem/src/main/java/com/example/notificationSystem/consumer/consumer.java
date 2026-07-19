package com.example.notificationSystem.consumer;

import com.example.notificationSystem.dto.BookingEvent;
import com.example.notificationSystem.dto.NotificationEvent;
import com.example.notificationSystem.service.NotificationServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class consumer {
    @Autowired
    private NotificationServic notificationServic;
    @KafkaListener(topics = "notification-booking", groupId = "notification-group")
    public void consume(BookingEvent event){
        System.out.println("Event received");
        notificationServic.sendMail(event);
    }
}
