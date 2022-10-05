package designpatterns.factorymethod;

public class EmailNotification implements Notification {

  @Override
  public void sendNotification() {
    System.out.println("sending email notification");
  }

}
