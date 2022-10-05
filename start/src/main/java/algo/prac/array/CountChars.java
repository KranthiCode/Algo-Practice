package algo.prac.array;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountChars {

  public static void frequency(int[] arr) {
    Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
        .forEach(System.out::println);
  }

  public static void frequency(String str) {
    str.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
        .forEach(entry -> {
          System.out.println((char) entry.getKey().intValue() + " - " + entry.getValue());
        });
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 1, 2, 3, 1, 2, 1 };
    frequency(a);
    String str = "aaaadddbkjsksssdfkkkdllf";
    frequency(str);
  }
}
