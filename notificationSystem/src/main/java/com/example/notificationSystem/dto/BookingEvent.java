package com.example.notificationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingEvent {
    private String notificationId;

    private Long bookingId;
    private Long eventId;
    private String eventTitle;
    private String userEmail;
}
