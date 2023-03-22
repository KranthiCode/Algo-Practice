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
  static void printSubSets1(int[] input1, List<Integer> li, int index) {
    if (index == input1.length) {
      System.out.println(li.toString());
      return;
    }
    // not picking the element
    printSubSets1(input1, li, index + 1);

    // pick the element add it
    li.add(input1[index]);
    printSubSets1(input1, li, index + 1);
    li.remove(li.size() - 1);
  }

  static void printSubSets2(int[] input1, List<Integer> li, List<List<Integer>> result, int index) {
    if (index == input1.length) {
      result.add(li);
      return;
    }
    printSubSets2(input1, new ArrayList<>(li), result, index + 1);
    li.add(input1[index]);
    printSubSets2(input1, new ArrayList<>(li), result, index + 1);
  }

  public static void main(String[] args) {
    String input = "abc";
    printSubSets(input, "");

    int[] input1 = { 1, 2, 3 };
    List<Integer> li = new ArrayList<>();
    printSubSets1(input1, li, 0);

    // int[] input2 = { 4, 5, 6 };
    // List<List<Integer>> result = new ArrayList<>();
    // printSubSets2(input2, new ArrayList<>(), result, 0);
    // System.out.println(result.toString());
  }

}
