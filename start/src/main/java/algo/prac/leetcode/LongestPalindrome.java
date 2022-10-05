package algo.prac.leetcode;

public class LongestPalindrome {
  public static String longestPalindrome(String s) {
    int len = s.length();
    int maxLen = 0;
    for (int i = 0; i < len; i++) {
      System.out.println("i" + i);
      int currentLen = 0;
      for (int j = len - 1, t = i; j >= i && t < j; j--, t++) {
        // System.out.println(s.charAt(t) + " - " + s.charAt(j));
        System.out.println(t + " - " + j);

        if (s.charAt(t) != s.charAt(j)) {
          currentLen = 0;
          break;
        }
        currentLen = currentLen + 2;
      }
      maxLen = Math.max(maxLen, currentLen);

    }
    return null;
  }

  public static void main(String[] args) {
    longestPalindrome("hehh");
  }
}
