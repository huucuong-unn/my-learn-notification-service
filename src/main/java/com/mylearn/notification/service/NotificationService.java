package com.mylearn.notification.service;

import com.mylearn.common.event.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

  /**
   * Simulates sending a payment receipt email.
   * In Phase 4, this would integrate with an external provider like AWS SES or SendGrid.
   */
  //TODO: Integrate real email service in Phase 4
  public void sendPaymentReceipt(PaymentEvent event) {
    log.info("--- MOCK EMAIL SENDER ---");
    log.info("To: UserID {}", event.getUserId());
    log.info("Subject: Payment Successful - Confirmation #{}", event.getConfirmationNumber());
    log.info("Body: Thank you for purchasing Course {}. We have received your payment of ${}.",
        event.getCourseId(), (event.getAmountCents() / 100.0));
    log.info("--------------------------");

    // Simulate network delay for sending email
    try {
      Thread.sleep(500);
    } catch (InterruptedException ignored) {}
  }
}
