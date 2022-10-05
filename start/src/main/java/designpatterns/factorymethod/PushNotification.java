package designpatterns.factorymethod;

public class PushNotification implements Notification {

  @Override
  public void sendNotification() {
    System.out.println("sending push notification");

  }

}
