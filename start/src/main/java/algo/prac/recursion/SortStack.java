package algo.prac.recursion;

import java.util.Random;
import java.util.Stack;

public class SortStack {

  private static void sort(Stack<Integer> s) {
    if (s.size() == 1) {
      return;
    }
    int temp = s.pop();
    sort(s);
    insert(s, temp);
  }

  private static void insert(Stack<Integer> s, int elem) {
    if (s.isEmpty() || s.peek() <= elem) {
      s.push(elem);
      return;
    }
    int tempIns = s.pop();
    insert(s, elem);
    s.push(tempIns);
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    Random r = new Random();
    // it is hard to debug random ints in case of issues so add in reverse order
    // s.addAll(r.ints(10, 0, 11).boxed().collect(Collectors.toList()));
    for (int i = 10; i >= 0; i--) {
      // it is hard to debug random ints in case of issues so add in reverse order and
      // sort
      // s.push(r.ints(1, 0, 11).findFirst().getAsInt());
      s.push(i);
    }
    System.out.println(s);
    sort(s);
    System.out.println(s);
  }

}
