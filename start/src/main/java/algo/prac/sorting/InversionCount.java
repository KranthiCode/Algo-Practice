package algo.prac.sorting;

import java.util.Arrays;

public class InversionCount {
  // Given an array containing integers, you need to count the total number of
  // inversions
  // inversion - two elements a[i] and a[j] form an inversion if a[i] >a [j] and i
  // < j

  // based on divide and conquer algo just like merge sort
  // total no of inversion = left inversions + right inversions + cross inversions

  // 1. Divide the array into left and right
  // 2. Merge sort recursively sorts till left and right are sorted
  // 3. Merge left and right into single array

  public static int mergeSort(int[] a, int s, int e) {
    // base case since this is a recursive algo
    if (s >= e) {
      return 0;
    }
    // rec case
    int mid = (s + e) / 2;
    int leftInversions = mergeSort(a, s, mid);
    int rightInversions = mergeSort(a, mid + 1, e);
    int crossInversions = merge(a, s, e);
    return leftInversions + rightInversions + crossInversions;
  }

  // helper method
  public static int merge(int[] a, int s, int e) {
    int i = s;
    int m = (s + e) / 2;
    int j = m + 1;

    int count = 0;
    int[] temp = new int[e + 1];
    int index = 0;
    while (i <= m && j <= e) {
      if (a[i] < a[j]) {
        temp[index] = a[i];
        i++;
      } else {
        count += (m - i + 1);
        temp[index] = a[j];
        j++;
      }
      index++;
    }

    // copy elements from first array
    while (i <= m) {
      temp[index] = a[i];
      i++;
      index++;
    }

    // or copy elements from second array
    while (j <= e) {
      temp[index] = a[j];
      j++;
      index++;
    }

    // copy back the elements from temp to original array
    return count;
  }

  public static void main(String[] args) {
    int[] a = { 0, 5, 2, 3, 1 };
    System.out.println(mergeSort(a, 0, a.length - 1));

  }
}
