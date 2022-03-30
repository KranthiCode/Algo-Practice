package algo.prac.array;

import java.util.Arrays;

public class Utils {
  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }

  public static int[] copyOfArray(int[] a) {
    return Arrays.copyOf(a, a.length);
  }

}
