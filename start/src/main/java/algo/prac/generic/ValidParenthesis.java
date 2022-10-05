package algo.prac.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

  public static boolean isValid(String s) {
    Map<Character, Character> parenthesisMap = new HashMap<>();
    parenthesisMap.put(')', '(');
    parenthesisMap.put('}', '{');
    parenthesisMap.put(']', '[');

    if (s.length() == 1) {
      return false;
    }

    Stack<Character> stack = new Stack<>();
    stack.push(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (curr == '}' || curr == ']' || curr == ')') {
        if (stack.isEmpty() || stack.pop() != parenthesisMap.get(curr)) {
          return false;
        }
      } else {
        stack.push(curr);
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("()"));
  }

}
