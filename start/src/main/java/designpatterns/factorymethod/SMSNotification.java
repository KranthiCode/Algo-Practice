package designpatterns.factorymethod;

public class SMSNotification implements Notification {

  @Override
  public void sendNotification() {
    System.out.println("send sms notification");
  }

}
