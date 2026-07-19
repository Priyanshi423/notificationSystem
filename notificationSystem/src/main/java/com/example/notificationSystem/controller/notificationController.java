package com.example.notificationSystem.controller;

import com.example.notificationSystem.dto.NotificationEvent;
import com.example.notificationSystem.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class notificationController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody NotificationEvent notificationEvent){
        kafkaProducerService.sendMessage(notificationEvent);
        return "message sent successfully";
    }

}
