package algo.prac.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {

  // Brute force
  public static void pairSum(int[] arr, int sum) {
    // Arrays.sort(arr);
    // To sort in reverse order you must use Integer objects array
    // Arrays.sort(arr, Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == sum) {
          System.out.println(arr[i] + "," + arr[j]);
          return;
        }
      }
    }
  }

  public static void pairSumUsingSort(int[] arr, int sum) {
    Arrays.sort(arr);
    int p1 = 0;
    int p2 = arr.length - 1;
    while (p1 < p2) {
      if (arr[p1] + arr[p2] == sum) {
        System.out.println(arr[p1] + "," + arr[p2]);
        return;
      } else if (arr[p1] + arr[p2] < sum) {
        p1++;
      } else {
        p2--;
      }
    }
  }

  public static void pairSumUsingSet(int[] arr, int sum) {
    Set<Integer> set = new HashSet<>();
    set.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      if (set.contains(sum - arr[i])) {
        System.out.println(arr[i] + "," + (sum - arr[i]));
        return;
      } else {
        set.add(arr[i]);
      }
    }

  }

  public static void main(String[] args) {
    int[] arr = { 10, 5, 2, 3, -6, 9, 11 };
    int[] a = { 1, 2, 3, 4 };
    pairSum(arr, 5);
    pairSumUsingSort(arr, 5);
    pairSumUsingSet(a, 4);
  }

}
