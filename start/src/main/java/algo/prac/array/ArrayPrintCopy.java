package algo.prac.array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayPrintCopy {

  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6 };
    // Print all array elements
    // 1
    Arrays.stream(a).forEach(System.out::println);
    Arrays.stream(a).forEach(i -> System.out.print(i * 5));
    // 2
    for (int i : a) {
      System.out.println(i);
    }
    // 3
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }

    // Copying all array elements
    // 1
    int[] b = Arrays.copyOf(a, a.length);

    // 2
    int[] c = new int[a.length];
    System.arraycopy(a, 0, c, 0, a.length);

    // 3 - does deep copy for 1-D array but shallow copy for 2-D array
    int[] d = a.clone();

    // 1. Sort Array
    Arrays.sort(a);

    // 2. Sort Array in reverse order - Collections.reverse is applicable on Non
    // Primitives/Objects
    Integer[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
    Arrays.sort(arr, Collections.reverseOrder());

    String[] k = { "ab", "bc", "ed", "gf", "wed" };
    Arrays.sort(k, Collections.reverseOrder());

  }

}
