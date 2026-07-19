package com.example.notificationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class NotificationSystemApplication {

	public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("JVM TZ = " + java.util.TimeZone.getDefault());

        SpringApplication.run(NotificationSystemApplication.class, args);
	}

}
