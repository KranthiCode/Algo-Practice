package algo.prac.array;

public class ArrayReverse {
  public static void reverseArray(int[] arr) {
    for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
      swap(arr, i, j);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    // before reverse
    for (int i : a) {
      System.out.println(i);
    }

    // reverse
    reverseArray(a);

    // after reverse
    for (int i : a) {
      System.out.println(i);
    }

  }
}
