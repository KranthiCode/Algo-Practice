package algo.prac.recursion;

public class Fibonacci {

  static int nthFibonacciNumber(int n) {
    if (n <= 1)
      return n;
    int last = nthFibonacciNumber(n - 1);
    int secondLast = nthFibonacciNumber(n - 2);
    return last + secondLast;
  }

  public static void main(String[] args) {
    System.out.println(nthFibonacciNumber(4));
  }
}
