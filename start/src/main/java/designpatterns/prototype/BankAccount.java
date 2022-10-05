package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Cloneable {

  public BankAccount() {
  }

  private List<String> cards = new ArrayList<>();

  public List<String> loadCards() {
    cards.add("card 1");
    cards.add("card 2");
    cards.add("card 3");
    cards.add("card 4");
    cards.add("card 5");

    return cards;
  }

  public List<String> getCards() {
    return cards;
  }

  @Override
  protected BankAccount clone() throws CloneNotSupportedException {
    BankAccount a = new BankAccount();
    for (String card : this.cards) {
      a.getCards().add(card);
    }
    return a;
  }

}
