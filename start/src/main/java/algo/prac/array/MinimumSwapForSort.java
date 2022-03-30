package algo.prac.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapForSort {

  public static void main(String[] args) {
    int[] a = { 7, 16, 14, 17, 6, 9, 5, 3, 18 };
    countMinNoOfSwap(a);
    System.out.println(minSwaps(a));
  }

  private static void countMinNoOfSwap(int[] a) {
    // store the actual positions of numbers
    Map<Integer, Integer> oldPositions = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      oldPositions.putIfAbsent(a[i], i);
    }

    // oldPositions.forEach((k, v) -> System.out.println(k + "," + v));

    // sort the array
    Arrays.sort(a);

    // Main logic
    boolean[] visited = new boolean[a.length];
    Arrays.fill(visited, false); // otpional because by deafult all values are set to false

    int ans = 0;
    for (int i = 0; i < a.length; i++) {
      // if elements is visited or element is in right position do nothing
      int oldPosition = oldPositions.get(a[i]);
      if (visited[i] == true || oldPosition == i) {
        System.out.println("no change needed" + a[i]);
        continue;
      }

      // visiting the element (index) for first time
      int j = i, cycleSize = 0;
      System.out.println("cycle start ");
      while (!visited[j]) {
        System.out.println("Visiting : " + a[j]);
        visited[j] = true;
        j = oldPositions.get(a[j]);
        cycleSize += 1;
      }
      System.out.println("cylce end");
      if (cycleSize > 0) {
        // System.out.println("cycle = " + cycleSize);
        ans = ans + (cycleSize - 1);
        System.out.println(ans);
      }

    }
    System.out.println("minimum swaps " + ans);
  }

  public static int minSwaps(int[] nums) {
    int len = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++)
      map.put(nums[i], i);

    Arrays.sort(nums);

    // To keep track of visited elements. Initialize
    // all elements as not visited or false.
    boolean[] visited = new boolean[len];
    Arrays.fill(visited, false);

    // Initialize result
    int ans = 0;
    for (int i = 0; i < len; i++) {

      // already swapped and corrected or
      // already present at correct pos
      if (visited[i] || map.get(nums[i]) == i)
        continue;

      // System.out.println("Checking cycle:");
      int j = i, cycle_size = 0;
      while (!visited[j]) {
        visited[j] = true;

        // move to next node
        j = map.get(nums[j]);
        cycle_size++;
      }

      // Update answer by adding current cycle.
      if (cycle_size > 0) {
        ans += (cycle_size - 1);
      }
    }
    return ans;
  }
}
