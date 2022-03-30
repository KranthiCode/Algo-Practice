package algo.prac.generic;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenerateAllSubSets {

  public static void printSubSets(int[] arr) {
    int n = (int) Math.pow(2, arr.length);
    for (int i = 0; i < n - 1; i++) {
      String str = "";
      int temp = i;
      for (int j = 0; j < arr.length; j++) {
        int rem = temp % 2;
        temp = temp / 2;
        if (rem != 0)
          str = str + " " + arr[j];
      }
      System.out.println(str);
    }
  }

  public static void printSubSets1(int[] arr) {
    int n = (int) Math.pow(2, arr.length);
    for (int i = 0; i < n - 1; i++) {
      String str = "";
      for (int j = 0; j < arr.length; j++)
        if ((i & (1 << j)) != 0)
          str = str + " " + arr[j];
      System.out.println(str);
    }
  }

  public static void printSubSetsRecursion(int[] arr, int index, String out) {
    int n = arr.length;
    if (index == n) {
      System.out.println(out);

      return;
    }
    printSubSetsRecursion(arr, index + 1, out + "" + arr[index]);
    printSubSetsRecursion(arr, index + 1, out);
  }

  private static void printSubSetRecursion(int[] arr, int index, int[] out) {
    int n = arr.length;
    if (index == n) {
      for (int i : out) {
        if (i != 0) {
          System.out.print(i);
        }
      }
      System.out.println();
      return;
    }
    out[index] = arr[index];
    printSubSetRecursion(arr, index + 1, out);
    out[index] = 0;
    printSubSetRecursion(arr, index + 1, out);

  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };

    // printSubSets(arr);
    // System.out.println("----");
    // printSubSets1(arr);
    // printSubSetsRecursion(arr, 0, "");
    printSubSetRecursion(arr, 0, new int[arr.length]);

    String str = "google";
    System.out.println((char) str.chars()
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() == 1)
        .findFirst()
        .map(Entry::getKey)
        .orElseThrow(() -> new RuntimeException("No char found"))
        .intValue());

    // int[] arrK = { 6, 4, 3, 9, 1, 8, 2, 5, 7 };
    // // 1
    // for (int i = 0; i < arrK.length; i++) {
    // System.out.println(arrK[i]);
    // }
    // // 2
    // for (int i : arrK) {
    // System.out.println(i);
    // }
    // // 3
    // System.out.println(Arrays.toString(arrK));
    // // 4
    // Arrays.stream(arrK).forEach(System.out::println);
  }

}