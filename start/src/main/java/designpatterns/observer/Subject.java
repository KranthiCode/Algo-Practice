package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
  private String subjectDesc;
  List<Observer> observers = new ArrayList<>();

  public Subject(String subjectDesc) {
    this.subjectDesc = subjectDesc;
  }

  public void subscribe(Observer ob) {
    observers.add(ob);
  }

  public void unSubscribe(Observer ob) {
    observers.remove(ob);
  }

  public void notifyObeservers() {
    for (Observer observer : this.observers) {
      observer.update(this.subjectDesc);
    }
  }

}
