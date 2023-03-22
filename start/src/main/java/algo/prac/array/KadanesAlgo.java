package algo.prac.array;

import java.util.ArrayList;
import java.util.List;

class KadanesAlgo {
  public static int subArrayWithMaxSum(int[] nums) {
    int curMax = 0;
    int maxTillNow = Integer.MIN_VALUE;
    for (int i : nums) {
      curMax = Math.max(i, curMax + i);
      maxTillNow = Math.max(curMax, maxTillNow);
    }
    return maxTillNow;
  }

  public static void subArrayWithMaxSumOn2(int[] nums) {
    int maxSum = nums[0];
    int start = nums[0], end = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int currentSum = nums[i];
      for (int j = i; j < nums.length; j++) {
        currentSum = currentSum + nums[j];
        if (maxSum < currentSum) {
          maxSum = currentSum;
          start = i;
          end = j;
        }
      }

    }
    System.out.println(maxSum);
    for (int i = start; i < end; i++) {
      System.out.print(nums[i] + ",");
    }
    System.out.print(nums[end]);
    System.out.println();
  }

  // abc
  // a, b, c
  // input
  public static void subArrayWithMaxSumRecursive(int[] nums, int index, List<Integer> li) {
    if (nums.length == index) {
      System.out.println(li.toString());
      return;
    }

    subArrayWithMaxSumRecursive(nums, index + 1, new ArrayList<>(li));
    li.add(nums[index]);
    subArrayWithMaxSumRecursive(nums, index + 1, new ArrayList<>(li));
    li.remove(li.size() - 1);
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 3, -2 };

    // subArrayWithMaxSumRecursive(a, 0, new ArrayList<>());
    subArrayWithMaxSumOn2(a);

  }
}