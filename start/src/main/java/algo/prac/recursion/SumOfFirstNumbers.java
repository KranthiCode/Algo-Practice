package algo.prac.recursion;

public class SumOfFirstNumbers {

  static int sumOfFirstNumbers(int n) {
    if (n == 0) {
      return 0;
    }
    return n + sumOfFirstNumbers(n - 1);
  }

  static void sumOfFirstNumbers1(int n, int sum) {
    if (n < 1) {
      System.out.println("Other way: " + sum);
      return;
    }
    sumOfFirstNumbers1(n - 1, sum + n);

  }

  public static void main(String[] args) {
    System.out.println(sumOfFirstNumbers(10));
    sumOfFirstNumbers1(10, 0);
  }
}
