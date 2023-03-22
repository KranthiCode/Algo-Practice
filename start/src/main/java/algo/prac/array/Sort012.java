package algo.prac.array;

import java.util.Arrays;

public class Sort012 {
  // Given an array nums with n objects colored red, white, or blue, sort them
  // in-place so that objects of the same color are adjacent, with the colors in
  // the order red, white, and blue.

  // We will use the integers 0, 1, and 2 to represent the color red, white, and
  // blue, respectively.

  // You must solve this problem without using the library's sort function.

  // Input: nums = [2,0,2,1,1,0]
  // Output: [0,0,1,1,2,2]

  // This is Dutch National Flag problem
  // Think like all 0s should be at left part of array, 1s to be in middle and 2s
  // be at right part of array.
  private static void sortColors(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
      switch (nums[mid]) {
        case 0:
          if (mid != low) {
            swapPositionsInIntArray(nums, low, mid);
          }
          low++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swapPositionsInIntArray(nums, mid, high);
          high--;
          break;
      }
    }
  }

  private static void sortColors1(int[] nums) {
    int n0 = -1, n1 = -1, n2 = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        nums[++n2] = 2;
        nums[++n1] = 1;
        nums[++n0] = 0;
      } else if (nums[i] == 1) {
        nums[++n2] = 2;
        nums[++n1] = 1;
      } else {
        nums[++n2] = 2;
      }
    }
  }

  private static void sortColors2(int[] nums) {
    int j = 0, k = nums.length - 1;
    for (int i = 0; i <= k; i++) {
      if (nums[i] == 0 && i != j) {
        swapPositionsInIntArray(nums, i, j);
        i--;
        j++;
      } else if (nums[i] == 2 && i != k) {
        swapPositionsInIntArray(nums, i, k);
        i--;
        k--;
      }
    }
  }

  private static void sortColors3(int[] nums) {
    int j = 0, k = nums.length - 1;
    for (int i = 0; i <= k; i++) {
      if (nums[i] == 0 && i != j)
        swapPositionsInIntArray(nums, i, j++);
      else if (nums[i] == 2 && i != k)
        swapPositionsInIntArray(nums, i, k--);
    }
    System.out.println(Arrays.toString(nums));
  }

  private static void swapPositionsInIntArray(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 0, 2, 1, 1, 0 };
    sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}
