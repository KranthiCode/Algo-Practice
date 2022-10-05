package algo.prac.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  static void printSubSets(String input, String output) {
    if (input.equals("")) {
      System.out.println(output);
      return;
    }
    String output1 = output;
    String output2 = output + input.charAt(0);
    input = input.substring(1, input.length());
    printSubSets(input, output1);
    printSubSets(input, output2);
  }

  // This is better than input/output one in cases of taking integer arrays
  // instead of strings
  static void printSubSets1(int[] input1, List<Integer> li, int index, int n) {
    if (index == n) {
      System.out.println(li.toString());
      // if (li.isEmpty())
      // System.out.println("{}");
      return;
    }

    // not picking the element
    printSubSets1(input1, li, index + 1, n);

    // pick the element add it
    li.add(input1[index]);
    printSubSets1(input1, li, index + 1, n);
    li.remove(Integer.valueOf(input1[index]));
  }

  public static void main(String[] args) {
    String input = "abcd";
    printSubSets(input, "");
    int[] input1 = { 1, 2, 3 };
    List<Integer> li = new ArrayList<>();
    printSubSets1(input1, li, 0, input1.length);

  }

}
