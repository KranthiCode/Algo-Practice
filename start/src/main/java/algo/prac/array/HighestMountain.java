package algo.prac.array;

import java.util.Stack;

public class HighestMountain {

  // My approch
  // A mountain is formed with a pattern of increase, then decrease and then
  // starts to increase so my code checks for first ever increament and then
  // decreament if it finds next increasement it considers that the pattern is
  // formed and calculates the mountain length. It countinues to do the same
  // pattern identification till it reaches the end of the array
  public static void highestMountainWithPattern(int[] a) {
    Stack<String> status = new Stack<>();
    int start = 0;
    int maxPeak = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[i] > a[i - 1]) {
        if (status.size() == 2) {
          if ((i - start) > maxPeak) {
            maxPeak = (i - start);
          }
          start = i - 1;
          status.pop();
        } else if (status.isEmpty()) {
          status.push("inc");
          start = i - 1;
        }
      } else {
        if (!status.isEmpty() && status.peek().equals("inc")) {
          status.push("desc");
        }
      }
    }
    System.out.println(maxPeak);
  }

  public static void highestMountainCounting(int[] a) {
    int maxPeak = 0;
    // Check a[i] is peak or not
    for (int i = 1; i < a.length - 2;) {
      if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
        // count backward till hit increment condition
        int count = 1;
        for (int j = i; j > 0; j--) {
          if (a[j] > a[j - 1]) {
            count += 1;
          } else {
            break;
          }
        }

        // count forward till hit increment condition
        for (; i < a.length - 2; i++) {
          if (a[i] > a[i + 1]) {
            count += 1;
          } else {
            break;
          }
        }
        maxPeak = count > maxPeak ? count : maxPeak;
      } else {
        i++;
      }
    }
    System.out.println(maxPeak);
  }

  public static void main(String[] args) {
    int[] a = { 5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4 };
    // int[] a = { 2, 1, 4, 7, 3, 2, 5 };
    highestMountainWithPattern(a);
    highestMountainCounting(a);
  }

}
