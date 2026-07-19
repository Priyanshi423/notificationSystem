package com.example.notificationSystem.service;

import com.example.notificationSystem.dto.BookingEvent;
import com.example.notificationSystem.dto.NotificationEvent;
import com.example.notificationSystem.entity.Notification;
import com.example.notificationSystem.model.BookingStatus;
import com.example.notificationSystem.model.NotificationStatus;
import com.example.notificationSystem.repository.NotificationRepository;
import com.example.notificationSystem.services.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.notificationSystem.model.NotificationStatus.*;

@Service
public class NotificationServic {
    @Autowired
private NotificationRepository notificationRepository;
    @Autowired
    private emailService emailService;
    public void sendMail(BookingEvent notificationEvent) {
        Notification notification = new Notification();
        notification.setBookingId(notificationEvent.getBookingId());
        notification.setEmail(notificationEvent.getUserEmail());
        notification.setBookingStatus(BookingStatus.PROCESSING);
        notification.setNotificationId(notificationEvent.getNotificationId());
        notification.setEventId(notificationEvent.getEventId());
        notification.setEventTitle(notificationEvent.getEventTitle());
        notificationRepository.save(notification);
        notification.setBookingStatus(BookingStatus.CONFIRMED);
        emailService.sendEmail(notificationEvent.getUserEmail(),"Booking Confirmation", "Hello Guddaaa, your booking has been confirmed with booking id "+notificationEvent.getBookingId());
       notification.setNotificationStatus(NotificationStatus.SENT);
        notificationRepository.save(notification);

    }

    public void markdlq(NotificationEvent notificationEvent) {
        if(notificationEvent.getNotificationId() == null){
            System.out.println("Notification Id is null");
            return;
        }

        Notification notification = notificationRepository.findByNotificationId(notificationEvent.getNotificationId()).orElseThrow();
        notification.setNotificationStatus(DLQ);
        notification.setFailureReason("sent to dlq after retires");
        notificationRepository.save(notification);
    }
}
