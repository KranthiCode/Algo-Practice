package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {
  private String name;
  List<Subject> subjects = new ArrayList<>();

  public Observer(String name) {
    this.name = name;
  }

  public void update(String subject) {
    System.out.println(this.name + " recevied a message from subject : " + subject);
  }

  @Override
  public String toString() {
    return "Observer [name=" + name + ", subjects=" + subjects + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    Observer other = (Observer) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
