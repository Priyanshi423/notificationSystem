package com.example.notificationSystem.entity;

import com.example.notificationSystem.model.BookingStatus;
import com.example.notificationSystem.model.NotificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private String notificationId;

    private String email;

    private NotificationStatus notificationStatus;
    private BookingStatus bookingStatus;

    private String eventTitle;
    private Long eventId;

    private LocalDateTime sentAt;

    private String failureReason;
}