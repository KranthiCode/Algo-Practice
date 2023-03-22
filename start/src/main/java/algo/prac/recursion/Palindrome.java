package algo.prac.recursion;

public class Palindrome {

  static boolean isPalindrome(String str, int i, int n) {
    if (i >= n / 2)
      return true;
    if (str.charAt(i) != str.charAt(n - i - 1))
      return false;
    return isPalindrome(str, i + 1, n);
  }

  public static void main(String[] args) {
    String str = "madam";
    System.out.println(isPalindrome(str, 0, str.length()));
  }

}
