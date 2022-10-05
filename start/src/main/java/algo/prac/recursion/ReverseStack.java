package algo.prac.recursion;

import java.util.Stack;

public class ReverseStack {
  static void reverse(Stack<Integer> s) {
    if (s.size() == 1) {
      return;
    }
    int temp = s.pop();
    reverse(s);
    insert(s, temp);
  }

  static void insert(Stack<Integer> s, int elem) {
    if (s.isEmpty()) {
      s.push(elem);
      return;
    }
    int tempIns = s.pop();
    insert(s, elem);
    s.push(tempIns);
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < 10; i++) {
      s.push(i);
    }
    System.out.println(s);
    reverse(s);
    System.out.println(s);
  }
}
