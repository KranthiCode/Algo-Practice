package algo.prac.generic;

import java.util.Arrays;
import java.util.Stack;

public class LongestCommonPrefix {
  // This is first approach
  public String longestCommonPrefix(String[] strs) {
    int smallestLength = findSmallestLength(strs);
    String common = "";
    String first = strs[0];

    for (int i = 0; i < smallestLength; i++) {
      char temp = first.charAt(i);
      for (int j = 1; j < strs.length; j++) {
        // System.out.println("looking ji - "+j+":"+i);
        if (strs[j].charAt(i) != temp) {
          return common;
        }
      }
      Stack<String> st = new Stack<>();

      common = common + temp;
    }
    return common;

  }

  public int findSmallestLength(String[] strs) {
    int smallest = Integer.MAX_VALUE;
    for (String str : strs) {
      smallest = str.length() < smallest ? str.length() : smallest;
    }
    return smallest;
  }

  // After some hints
  public static String oneMsCode(String[] strs) {
    if (strs.length == 0) {
      return "";
    } else if (strs.length == 1) {
      return strs[0];
    }
    Arrays.sort(strs);
    String smallest = strs[0];
    String largest = strs[strs.length - 1];
    int i = 0;

    int minLen = Math.min(smallest.length(), largest.length());

    while (i < minLen && smallest.charAt(i) == largest.charAt(i)) {
      i++;
    }
    if (i == 0) {
      return "";
    }
    return smallest.substring(0, i);
  }

  // Fastest
  public String longestCommonPrefixTop(String[] strs) {
    if (strs.length == 0)
      return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
      while (strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty())
          return "";
      }
    return prefix;
  }
}
