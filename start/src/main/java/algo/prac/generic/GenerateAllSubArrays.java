package algo.prac.generic;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.Map.Entry;

public class GenerateAllSubArrays {
  private static void subArrays(int[] arr) {
    int arrLen = arr.length;
    for (int start = 0; start < arrLen; start++) {
      // sub array length will always start with one
      for (int subArrLen = start + 1; subArrLen <= arrLen; subArrLen++) {
        for (int index = start; index < subArrLen; index++) {
          System.out.print(" " + arr[index] + " ");
        }
        System.out.println();
      }
    }
  }

  private static void subArraysRecursion(int[] arr, int index) {
    if (index == arr.length) {
      return;
    }
    LinkedHashMap<Integer, Long> lhm = new LinkedHashMap<>();
    for (Entry entry : lhm.entrySet()) {

    }
    String str = "";
    for (int i = index; i < arr.length; i++) {
      str += " " + arr[i] + " ";
      System.out.println(str);
    }
    // System.out.println();
    subArraysRecursion(arr, index + 1);
  }

  private static void subStrings(String str) {
    int len = str.length();
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j <= len; j++) {
        System.out.println(str.substring(i, j));
      }
    }
  }

  private static void subStrings1(String str) {
    int len = str.length();
    for (int i = 0; i < len; i++) {
      String subStr = "";
      for (int j = i + 1; j < len; j++) {
        subStr = subStr + str.charAt(j);
        System.out.println(subStr);
      }
    }
  }

  private static void subStringRecursive(String str, int start) {

    if (start == str.length() - 1) {
      return;
    }
    String subStr = "";
    for (int i = start; i < str.length(); i++) {
      subStr = subStr + str.charAt(i);
      System.out.println(subStr);

    }
    subStringRecursive(str, start + 1);
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4 };
    int[] arrA = {};
    int[] arrB = { 1 };
    // System.out.println("----1----");
    // subArrays(arr);
    // System.out.println("----2----");
    // subArrays(arrA);
    // System.out.println("----3----");
    // subArrays(arrB);
    // subArrays(arr);
    // System.out.println("-----Recursion-----");
    // subArraysRecursion(arr, 0);
    // subStrings("kran");
    // subStringRecursive("kran", 0);
  }
}
