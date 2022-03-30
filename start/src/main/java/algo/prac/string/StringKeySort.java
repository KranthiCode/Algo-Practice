package algo.prac.string;

import java.util.Arrays;
import java.util.Comparator;

public class StringKeySort {
  public static void keySort(String[] strArr, int col, boolean reverse, String ordering) {

    Pair[] pairs = new Pair[strArr.length];
    for (int i = 0; i < strArr.length; i++) {
      pairs[i] = new Pair();
      pairs[i].key = strArr[i].split(" ")[col - 1];
      pairs[i].value = strArr[i];
    }
    // Lexographic comparision
    Comparator<Pair> lexographicComparator = new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return o1.key.compareTo(o2.key);
      }
    };
    // Numeric comparision
    Comparator<Pair> numericComparator = new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return Integer.valueOf(o1.key).compareTo(Integer.valueOf(o2.key));
      }
    };

    if (ordering.equals("numeric"))
      Arrays.sort(pairs, numericComparator);
    else
      Arrays.sort(pairs, lexographicComparator);

    if (reverse) {
      for (int i = 0, j = pairs.length - 1; i < j; i++, j--) {
        Pair temp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = temp;
      }
    }

    Arrays.stream(pairs).forEach(pair -> System.out.println(pair.toString()));
    Arrays.stream(pairs).sorted();

  }

  public static void main(String[] args) {
    String[] strArr = { "10 20", "30 40", "50 60", "70 80", "0100 0120" };

    keySort(strArr, // array of elements
        2, // column
        true, // reverse order
        "lexo" // camparision type
    );

  }
}

class Pair {
  String key;
  String value;

  @Override
  public String toString() {
    return this.key + " - " + this.value;
  }

}
// chalo USA
// 60L property EMI - 33K / Down 13L - 1290sqft
// 47L - 30y - 6.5% - 7.5%
// MOURI TECH

// gulmahar
// dominos
// lingampally route