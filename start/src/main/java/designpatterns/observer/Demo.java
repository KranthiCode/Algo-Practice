package designpatterns.observer;

public class Demo {
  public static void main(String[] args) {
    Subject s1 = new Subject("subject 1");
    Subject s2 = new Subject("subject 2");

    Observer o1 = new Observer("o1");
    Observer o2 = new Observer("o2");
    Observer o3 = new Observer("o3");
    Observer o4 = new Observer("o4");
    Observer o5 = new Observer("o5");
    Observer o6 = new Observer("o6");

    s1.subscribe(o1);
    s1.subscribe(o2);
    s1.subscribe(o3);
    s2.subscribe(o4);
    s2.subscribe(o5);
    s2.subscribe(o6);

    s1.notifyObeservers();
    s2.notifyObeservers();

    s1.unSubscribe(o1);
    s2.unSubscribe(o6);

    System.out.println("---------");

    s1.notifyObeservers();
    s2.notifyObeservers();

  }
}
