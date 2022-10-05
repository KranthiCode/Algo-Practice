package algo.prac.generic;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

  public static int romanToInt(String str) {
    int val = 0;

    Map<String, Integer> romanConv = new HashMap<>();
    romanConv.put("I", 1);
    romanConv.put("V", 5);
    romanConv.put("X", 10);
    romanConv.put("L", 50);
    romanConv.put("C", 100);
    romanConv.put("D", 500);
    romanConv.put("M", 1000);

    for (int i = 1; i <= str.length(); i++) {
      if (i == str.length()) {
        val += romanConv.get("" + str.charAt(i - 1));
        break;
      }

      int prevValue = romanConv.get("" + str.charAt(i - 1));
      int currentValue = romanConv.get("" + str.charAt(i));

      if (currentValue > prevValue) {
        val -= prevValue;
      } else {
        val += prevValue;
      }

    }
    return val;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("CD"));
  }

}
