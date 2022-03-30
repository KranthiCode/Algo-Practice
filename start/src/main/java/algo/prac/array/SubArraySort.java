package algo.prac.array;

import java.util.Arrays;
import static algo.prac.array.Utils.min;
import static algo.prac.array.Utils.max;

public class SubArraySort {
  // Follow up questions
  // 1. know if numbers are repeated
  // 2. know if numbers are always incremented by 1
  // 3. know if numbers always integers [1, infinity]

  public static void sortSubArray1(int[] arr) {
    // 1. Copying a primitive array using System class
    // int[] arrCopy = new int[arr.length];
    // System.arraycopy(arr, 0, arrCopy, 0, arr.length);

    // 2. Copying primitive array using Arrays class
    int[] arrCopy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arrCopy);

    int startingIndex = 0;
    for (int i = 0; i < arrCopy.length - 1; i++) {
      if (arr[i] != arrCopy[i]) {
        startingIndex = i;
        break;
      }
    }

    int endingIndex = arr.length - 1;
    for (int j = arr.length - 1; j > 0; j--) {
      if (arr[j] != arrCopy[j]) {
        endingIndex = j;
        break;
      }
    }

    System.out.println("start: " + startingIndex + " , end: " + endingIndex);
  }

  public static void sortSubArray2(int[] arr) {
    int minUnSorted = Integer.MAX_VALUE;
    int maxUnSorted = Integer.MIN_VALUE;

    // check if a number is out of order
    // it's out of order if a number is less than it's previous or greater than next
    // element
    for (int i = 0; i < arr.length; i++) {
      int x = arr[i];
      if (isOutOfOrder(arr, i)) {
        minUnSorted = min(minUnSorted, x);
        maxUnSorted = max(maxUnSorted, x);
      }
    }

    // Check if there is no unsorted subarray
    if (minUnSorted == Integer.MAX_VALUE) {
      System.out.println("start: -1 , end: -1");
      return;
    }

    // find the posiiton for min unsorted element where it is less than next number
    int left = 0;
    while (minUnSorted >= arr[left]) {
      left++;
    }
    // find the position for max unsorted element where it is greater than previous
    // number
    int right = arr.length - 1;
    while (maxUnSorted <= arr[right]) {
      right--;
    }

    System.out.println("start: " + left + " , end: " + right);
  }

  private static boolean isOutOfOrder(int[] arr, int i) {
    int x = arr[i];
    // handles corner case of starting element itself out of order
    if (i == 0) {
      return x > arr[1];
    }
    // handles corner case of end elemtn is out of order
    if (i == arr.length - 1) {
      return x < arr[i - 1];
    }
    return x < arr[i - 1] || x > arr[i + 1];
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11 };
    int[] arr_1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10 };
    sortSubArray1(arr);
    sortSubArray2(arr);
  }

}
