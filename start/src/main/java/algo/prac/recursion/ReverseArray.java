package algo.prac.recursion;

import java.util.Arrays;

public class ReverseArray {
  static void reverseArray(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    swap(arr, start, end);
    start++;
    end--;
    reverseArray(arr, start, end);
  }

  static void reverseArray1(int[] arr, int i, int n) {
    if (i >= n / 2)
      return;
    swap(arr, i, n - i - 1);
    reverseArray1(arr, i + 1, n);
  }

  static void swap(int[] arr, int start, int end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
  }

  public static void main(String[] args) {
    int[] arr = { 6, 4, 3, 9, 1, 8, 2, 5, 7 };
    Arrays.stream(arr).forEach(System.out::print);
    System.out.println();
    reverseArray1(arr, 0, arr.length);
    Arrays.stream(arr).forEach(System.out::print);
    System.out.println();
  }

}
