package work;

public class Test1 {

  public static int squareRoot(int x) {
    if (x == 1) {
      return 1;
    }
    int end = x / 2;
    int start = 2;
    int mid = (start + end) / 2;
    
    while (start < end) {
      mid = (end + start) / 2;
      if (mid * mid == x || (mid) * (mid) < x && (mid + 1) * (mid + 1) > x) {
        return mid;
      } else if (mid * mid < x) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return mid - 1;
  }

  public static void main(String[] args) {
    System.out.println(squareRoot(80));
  }

}
