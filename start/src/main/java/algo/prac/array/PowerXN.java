package algo.prac.array;

public class PowerXN {

  // recursion need to handle the integer overflow case using n%2 ==0 condition
  // and by reducting the time compelexity
  private static double myPowUtil(double x, long n) {
    if (n == 0)
      return 1.0;
    if (n < 0) {
      return myPowUtil(1 / x, -n) + 1;
    }
    // return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    return n % 2 == 0 ? myPowUtil(x * x, n / 2) : x * myPowUtil(x * x, n / 2);
  }

  private static double myPow(double x, int n) {
    return myPowUtil(x, n);
  }

  //
  private static double myPowIterative(double x, int n) {
    if (n == 0) {
      return 1.0;
    }
    double result = 1.0;
    if (n < 0) {
      while (n == 0) {
        result = result * 1 / x;
        n++;
      }
      return result;
    } else {
      while (n >= 1) {
        result = result * x;
        n--;
      }
      return result;
    }
  }

  public static void main(String[] args) {
    // double d = 0.00001;
    // int n = 2147483647;
    double d = 8;
    int n = 4;
    System.out.println(myPowIterative(d, n));
  }
}
