package designpatterns.factorymethod;

public class NotificatoinServiceTest {
  public static void main(String[] args) {
    NotificationFactory notifFactory = new NotificationFactory();
    Notification smsNotification = notifFactory.createNotification("SMS");
    smsNotification.sendNotification();
  }
}
