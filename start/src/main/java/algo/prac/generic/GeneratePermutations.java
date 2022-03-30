package algo.prac.generic;

import java.util.Arrays;

public class GeneratePermutations {

  // utility
  private static String swapPositionsInString(String str, int i, int j) {
    char[] chArr = str.toCharArray();
    char temp = chArr[i];
    chArr[i] = chArr[j];
    chArr[j] = temp;
    return String.valueOf(chArr);
  }

  // utility
  private static void swapPositionsInIntArray(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Permutations of string with recursion
  private static void generatePermsStringRecursion(String str, int start, int end) {
    if (start == end - 1) {
      System.out.println(str);
    } else {
      for (int i = start; i < end; i++) {
        str = swapPositionsInString(str, start, i);
        generatePermsStringRecursion(str, start + 1, end);
        str = swapPositionsInString(str, start, i);
      }
    }
  }

  // Permutations of string without recursion
  private static void generatePermsString(String str, int start, int end) {

  }

  // Permutations of int array with recursion
  private static void generatePermsIntRecursion(int[] arr, int start, int end) {
    if (start == end - 1) {
      System.out.println(Arrays.toString(arr));
    } else {
      for (int i = start; i < end; i++) {
        swapPositionsInIntArray(arr, start, i);
        generatePermsIntRecursion(arr, start + 1, end);
        swapPositionsInIntArray(arr, start, i);
      }
    }
  }

  // Permutations of int array without recursion
  private static void generatePermsInt(int[] arr, int start, int end) {

  }

  // Main method to test the algorithms
  public static void main(String[] args) {
    generatePermsStringRecursion("1234", 0, "1234".length());
    int[] arr = { 1, 2, 3 };
    generatePermsIntRecursion(arr, 0, arr.length);
  }

}