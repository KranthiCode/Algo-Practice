package algo.prac.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonDivisibleSumPairs {

  private static int nonDivisibleSumPairsLength(int k, List<Integer> s) {
    // In maths. if (a + b) % k = 0 => then ((a % k) + (b % k)) % k = 0
    // Example: (5 + 7) % 6 = 0 => then (5 % 6) + (7 % 6) > (5 + 1) % 6 = 0
    int maxLength = 0;
    int[] remaindersCount = new int[k];
    // Storing count of remainders
    s.stream().forEach(i -> remaindersCount[i % k]++);

    System.out.println(Arrays.toString(remaindersCount));

    for (int index = 1; index < (k + 1) / 2; index++) {
      System.out.println("i: " + index + " k-i: " + (k - index));
      maxLength += Math.max(remaindersCount[index], remaindersCount[k - index]);
    }

    // For even values of K, the equal remainder is simular to the 0 case. For K =
    // 6, pairs are 1+5, 2+4, 3+3. For values with remainder 3, at most one value
    // can be added to the result set.
    if (k % 2 == 0) {
      maxLength += remaindersCount[k / 2] > 0 ? 1 : 0;
    }

    // For the special case where remainder is 0, given the set of all values which
    // are individually divisible by K, they can't be paired with any others. So, at
    // most 1 value which is evenly divisible by K can be added to the result set.
    maxLength += remaindersCount[0] > 0 ? 1 : 0;

    return maxLength;
  }

  public static void main(String[] args) {
    int[] arr = { 6, 4, 3, 9, 1, 8, 2, 5, 7 };
    nonDivisibleSumPairsLength(6, Arrays.stream(arr).boxed().collect(Collectors.toList()));
  }
}
