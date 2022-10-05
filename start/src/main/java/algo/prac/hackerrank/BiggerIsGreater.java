package algo.prac.hackerrank;

public class BiggerIsGreater {
  public static String biggerIsGreater(String w) {
    // dhck - dhkc
    // dkhc - hcdk
    char[] chars = w.toCharArray();
    int len = w.length();
    int pivot = -1;

    // finding non increasing index - pivot
    for (int i = len - 2; i >= 0; i--) {
      if (chars[i] < chars[i + 1]) {
        pivot = i;
        break;
      }
    }
    if (pivot == -1) {
      return "no answer";
    }

    int successor = -1;
    for (int j = len - 1; j > pivot; j--) {
      if (chars[j] > chars[pivot]) {
        successor = j;
        break;
      }
    }
    // swap pivot and next largest
    char tempSwap = chars[pivot];
    chars[pivot] = chars[successor];
    chars[successor] = tempSwap;

    // reverse the chars after pivot
    for (int i = pivot + 1, j = len - 1; i < j; i++, j--) {
      char tempRev = chars[i];
      chars[i] = chars[j];
      chars[j] = tempRev;
    }

    return String.valueOf(chars);
  }

  public static void main(String[] args) {
    String s = new String("dkhc");
    System.out.println(biggerIsGreater(s));

  }
}
