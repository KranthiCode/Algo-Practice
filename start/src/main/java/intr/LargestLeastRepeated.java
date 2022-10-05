package intr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestLeastRepeated {

  private static int largestLeastRepeated(int[] arr) {
    // int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,49,49,50,50};

    Arrays.sort(arr);

    for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    // check for duplicates in one pass and if no duplicates return a[0]

    int minCount = Integer.MAX_VALUE;
    int leastRepatedMax = arr[0];
    Map<Integer, Integer> numFreq = new HashMap<Integer, Integer>();
    for (int i : arr) {

      if (numFreq.get(i) == null) {
        numFreq.put(i, 1);
      } else {
        int count = numFreq.get(i) + 1;
        numFreq.put(i, count);
      }
    }

    for (int i : arr) {
      if (numFreq.get(i) < minCount) {
        minCount = numFreq.get(i);
        leastRepatedMax = i;
      }
      if (minCount == 1) {
        return leastRepatedMax;
      }
    }

    return leastRepatedMax;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 49, 49, 50, 50 };
    System.out.println(largestLeastRepeated(arr));
  }
}
