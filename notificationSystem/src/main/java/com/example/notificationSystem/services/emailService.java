package com.example.notificationSystem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class emailService {
    private final JavaMailSender javaMailSender;
    public void sendEmail(String to, String subject , String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        System.out.println("email body created");

        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println("EMAIL ERROR: ");
            e.printStackTrace();
        }

    }
}
