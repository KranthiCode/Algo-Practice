package algo.prac.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class UniqueSubstring {
  // Given a string, write a function to find the largest
  // substring with unique characters (no duplicates)

  // start a window when you visit a char that is already visited
  // from the next index you have visited this

  public static void main(String[] args) {
    String a = "abcaebd";
    String b = "prateekbhaiya";
    largestSubstring(a);
    largestSubstring(b);
  }

  private static void largestSubstring(String a) {
    int i = 0;
    int j = 0;
    int length = a.length();
    int maxwindowLength = Integer.MIN_VALUE;
    int currentWindowLength = 0;
    int startWindow = -1;

    Map<Character, Integer> occurences = new HashMap<>();

    while (j < length) {

      char ch = a.charAt(j);
      if (occurences.containsKey(ch) && occurences.get(ch) >= i) {
        i = occurences.get(ch) + 1;
        currentWindowLength = j - i; // updated remaining window len excluding current char
      }

      // update last occurence
      occurences.put(ch, j);
      currentWindowLength++;
      j++;

      // update maxWindowLength at every step
      if (currentWindowLength > maxwindowLength) {
        maxwindowLength = currentWindowLength;
        startWindow = i;
      }
    }
    System.out.println(a.substring(startWindow, startWindow + maxwindowLength));
  }

}
