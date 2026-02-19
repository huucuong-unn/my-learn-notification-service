package com.mylearn.notification.consumer;

import com.mylearn.common.event.PaymentEvent;
import com.mylearn.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer that listens for payment-related events.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventConsumer {

  private final NotificationService notificationService;

  @KafkaListener(
      topics = "${app.kafka.topic.payment-events}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consumePaymentEvent(PaymentEvent event) {
    log.info("Received PaymentEvent from Kafka: {} for User: {}",
        event.getEventId(), event.getUserId());

    try {
      notificationService.sendPaymentReceipt(event);
      log.info("Successfully processed notification for event: {}", event.getEventId());
    } catch (Exception e) {
      log.error("Error processing PaymentEvent: {}. Error: {}",
          event.getEventId(), e.getMessage());
      // In production, you would implement retry logic or move this to a Dead Letter Topic (DLT)
    }
  }
}
