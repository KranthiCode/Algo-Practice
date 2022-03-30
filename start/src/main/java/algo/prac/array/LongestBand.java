package algo.prac.array;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {

  public static int lengthOfLongestBand(int[] a) {
    Set<Integer> numbers = new HashSet<>();

    for (int i : a) {
      numbers.add(i);
    }
    int largetBandLength = 1;

    for (int i : a) {
      if (!numbers.contains(i - 1)) {
        int nextNumber = i + 1;
        int count = 1;
        while (numbers.contains(nextNumber)) {
          nextNumber++;
          count++;
        }
        largetBandLength = max(largetBandLength, count);
      }
    }
    return largetBandLength;
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static void main(String[] args) {
    int[] a = { 1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6 };
    System.out.println(lengthOfLongestBand(a));
  }

}
