package algo.prac.string;

import java.util.Arrays;

public class StringTokenizer {

  private static void tokenizeString(String str) {
    for (String string : str.split(" ")) {
      System.out.println(string);
    }

    Arrays.stream(str.split(" ")).forEach(System.out::println);

  }

  public static void main(String[] args) {
    tokenizeString("hello world, how are you doing?");
  }

}
