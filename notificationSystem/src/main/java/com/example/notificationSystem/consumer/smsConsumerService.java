//package com.example.notificationSystem.consumer;
//
//import com.example.notificationSystem.dto.NotificationEvent;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class smsConsumerService {
//    @KafkaListener(topics="notification-events",groupId="sms-group")
//    public String consume(NotificationEvent notificationEvent){
//        if("SMS".equals(notificationEvent.getType())||"Both".equals(notificationEvent.getType())){
//            System.out.println("SMS sent to " + notificationEvent.getPhone());
//        }
//        return "SMS sent successfully";
//    }
//}
