package algo.prac.array;

import java.util.Arrays;

public class NextPermutation {
  // This is O(n^2) solution
  public static void nextPermutation(int[] nums) {
    boolean found = false;
    int largestIndex = Integer.MIN_VALUE;
    int largestSwapIndex = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] > nums[j]) {
          if (j > largestSwapIndex) {
            largestIndex = i;
            largestSwapIndex = j;
          }
          found = true;
        }
      }
    }

    if (!found) {
      for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    } else {
      int temp = nums[largestIndex];
      nums[largestIndex] = nums[largestSwapIndex];
      nums[largestSwapIndex] = temp;
      Arrays.sort(nums, largestSwapIndex + 1, nums.length);
    }
  }

  // O(n) solution
  public static void nextPermutation2(int[] arr) {
    // find a number that is greater than it's next number from the end of array
    int pivotIndex = -1;
    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i - 1] < arr[i]) {
        pivotIndex = i - 1;
        break;
      }
    }

    System.out.println("pivot index " + pivotIndex);

    // swap the pivot with successor if pivot was found else just reverse the array
    if (pivotIndex > -1) {
      // find the right most number that is greater than pivot
      int successorIndex = -1;
      for (int j = arr.length - 1; j >= 0; j--) {
        if (arr[pivotIndex] < arr[j]) {
          successorIndex = j;
          break;
        }
      }

      // swap pivot and successor
      swap(pivotIndex, successorIndex, arr);
    }

    // reverse the suffix that after the pivot or may be everthing if no pivot found
    for (int i = pivotIndex + 1, j = arr.length - 1; i < j; i++, j--) {
      swap(i, j, arr);
    }

  }

  public static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = { 4, 2, 0, 2, 3, 2, 0 };
    System.out.println(Arrays.toString(arr));
    nextPermutation2(arr);
    System.out.println(Arrays.toString(arr));
  }

}
