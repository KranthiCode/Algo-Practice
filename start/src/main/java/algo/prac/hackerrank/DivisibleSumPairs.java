package algo.prac.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DivisibleSumPairs {
  public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
    Map<Integer, Long> freqMap = ar.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    long count = 0;
    for (int i = 0; i < ar.size(); i++) {
      Integer current = ar.get(i);
      for (int j = i + 1; j < ar.size(); j++) {
        if (((int) current + (int) ar.get(j)) % k == 0 && freqMap.get(ar.get(j)) != null) {
          count = count + 1;
        }
      }
    }
    return Integer.parseInt("" + count);
  }

  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>(Arrays.asList(1, 3, 2, 6, 1, 2));
    System.out.println(divisibleSumPairs(l.size(), 3, l));
  }
}
