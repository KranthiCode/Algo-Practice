package designpatterns.factorymethod;

public class NotificationFactory {
  public Notification createNotification(String notificationType) {
    switch (notificationType) {
      case "SMS":
        return new SMSNotification();
      case "EMAIL":
        return new EmailNotification();
      case "PUSH":
        return new PushNotification();
      default:
        throw new IllegalArgumentException("Unknown notification type : " + notificationType);
    }
  }
}
