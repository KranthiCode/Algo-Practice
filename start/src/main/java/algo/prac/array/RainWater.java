package algo.prac.array;

public class RainWater {

  static int trappedWater(int[] a) {
    int length = a.length;
    if (length <= 2) {
      System.out.println("can't trap water here");
      return 0;
    }
    int water = 0;
    int[] leftHeights = new int[length];
    int[] rightHeights = new int[length];

    int max = a[0];
    for (int i = 0; i < length; i++) {
      max = max > a[i] ? max : a[i];
      leftHeights[i] = max;
    }
    max = a[length - 1];
    for (int j = length - 1; j >= 0; j--) {
      max = max > a[j] ? max : a[j];
      rightHeights[j] = max;
    }
    int index = 0;
    for (int i : a) {
      water = water + min(leftHeights[index], rightHeights[index]) - i;
      index++;
    }
    return water;
  }

  static int min(int a, int b) {
    return a < b ? a : b;
  }

  public static void main(String[] args) {
    int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int[] b = { 3, 2 };
    System.out.println(trappedWater(b));
  }
}
