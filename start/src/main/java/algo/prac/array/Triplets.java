package algo.prac.array;

import java.util.Arrays;

public class Triplets {

  // Use PairSum two pointer approach here
  public static void triplet(int[] arr, int targetSum) {
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = 0; i < n - 3; i++) {
      int p1 = i + 1;
      int p2 = n - 1;
      while (p1 < p2) {
        int currentSum = arr[i] + arr[p1] + arr[p2];
        if (currentSum == targetSum) {
          System.out.println(arr[i] + "," + arr[p1] + "," + arr[p2]);
          p1++;
          p2--;
        } else if (currentSum < targetSum) {
          p1++;
        } else {
          p2--;
        }
      }
    }
  }

  public static void main(String[] args) {
    triplet(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 15 }, 18);
  }

}
