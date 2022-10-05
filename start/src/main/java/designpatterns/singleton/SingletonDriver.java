package designpatterns.singleton;

public class SingletonDriver {

  // public static int main(String[] args) {
  // System.out.println("Hello");
  // return 0;
  // }

  public String toString() {
    return "";
  }

  public static void main(String[] args) {
    Singleton a = Singleton.getInstance();
    Singleton b = Singleton.getInstance();

    System.out.println(a.equals(b));
  }
}
