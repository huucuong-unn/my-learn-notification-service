package com.mylearn.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka // Enables Spring Kafka components
public class MyLearnNotificationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyLearnNotificationServiceApplication.class, args);
  }
}
