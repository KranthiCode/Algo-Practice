package algo.prac.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubSequenceSum {
  static void subSequenceSum(int[] arr, List<Integer> list, int index, int n, int sum, int currentSum) {

    if (index == n) {
      if (currentSum == sum) {
        System.out.println(list.toString());
      }
      return;
    }

    currentSum += arr[index];
    list.add(arr[index]);

    // pick call
    subSequenceSum(arr, list, index + 1, n, sum, currentSum);

    // don't pick call
    currentSum -= arr[index];
    list.remove(Integer.valueOf(arr[index]));
    subSequenceSum(arr, list, index + 1, n, sum, currentSum);
  }

  static boolean subSequenceSum1(int[] arr, List<Integer> list, int index, int n, int sum, int currentSum) {

    if (index == n) {
      if (currentSum == sum) {
        System.out.println(list.toString());
        return true;
      }
      return false;
    }

    currentSum += arr[index];
    list.add(arr[index]);

    // pick call
    if (subSequenceSum1(arr, list, index + 1, n, sum, currentSum))
      return true;

    // don't pick call
    currentSum -= arr[index];
    list.remove(Integer.valueOf(arr[index]));
    if (subSequenceSum1(arr, list, index + 1, n, sum, currentSum))
      return true;

    return false;
  }

  static int countSubSequenceSum(int[] arr, List<Integer> list, int index, int n, int sum, int currentSum) {

    if (index == n) {
      if (currentSum == sum) {
        return 1;
      }
      return 0;
    }

    currentSum += arr[index];
    list.add(arr[index]);

    // pick call
    int l = countSubSequenceSum(arr, list, index + 1, n, sum, currentSum);

    // don't pick call
    currentSum -= arr[index];
    list.remove(Integer.valueOf(arr[index]));
    int r = countSubSequenceSum(arr, list, index + 1, n, sum, currentSum);

    return l + r;
  }

  public static void main(String[] args) {
    int[] arr = { 6, 4, 3, 9, 1, 8, 2, 5, 7 };
    // Returns alls subsets that are equal to sum
    subSequenceSum(arr, new ArrayList<>(), 0, arr.length, 10, 0);

    // Returns only one subset that is equal to sum
    System.out.println(subSequenceSum1(arr, new ArrayList<>(), 0, arr.length, 10,
        0));

    System.out.println(countSubSequenceSum(arr, new ArrayList<>(), 0, arr.length,
        10, 0));

  }
}
