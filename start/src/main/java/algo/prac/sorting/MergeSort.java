package algo.prac.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MergeSort {
  public static void main(String[] args) {
    int[] a = { 2, 34, 23, 21, 7, 9, 10 };
    mergeSort(a, 0, a.length - 1);
    Arrays.stream(a).forEach(System.out::println);
    Map<String, Integer> hm = new HashMap<>();
    hm.entrySet().stream().sorted(Entry.comparingByValue())
        .collect(Collectors.toMap(Entry::toString, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    hm.entrySet().stream().sorted(Entry.comparingByValue()).collect(() -> new LinkedHashMap<>(),
        (c, e) -> c.put(e.getKey(), e.getValue()), (c1, c2) -> c1.putAll(c2));
  }

  // 1. Divide the array into left and right
  // 2. Merge sort recursively sorts till left and right are sorted
  // 3. Merge left and right into single array

  public static void mergeSort(int[] a, int s, int e) {
    // base case since this is a recursive algo
    if (s >= e) {
      return;
    }
    // rec case
    int mid = (s + e) / 2;
    mergeSort(a, s, mid);
    mergeSort(a, mid + 1, e);
    merge(a, s, e);
  }

  // helper method
  public static void merge(int[] a, int s, int e) {
    int i = s;
    int m = (s + e) / 2;
    int j = m + 1;

    int[] temp = new int[e + 1];
    int index = 0;
    while (i <= m && j <= e) {
      if (a[i] < a[j]) {
        temp[index] = a[i];
        i++;
      } else {
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
    int k = 0;
    for (int idx = s; idx <= e; idx++) {
      a[idx] = temp[k++];
    }
  }
}
