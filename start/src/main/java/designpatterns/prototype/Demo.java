package designpatterns.prototype;

public class Demo {
  public static void main(String[] args) throws CloneNotSupportedException {
    BankAccount a = new BankAccount();
    a.loadCards();

    System.out.println("a : " + a.getCards());

    BankAccount b = a.clone();
    a.getCards().remove(0);
    System.out.println("a : " + a.getCards());

    // Removing cards from object A after cloing is done will not effect object b
    System.out.println("b : " + b.getCards());
  }
}
