package algo.prac.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

  public static int[][] merge(int[][] intervals) {
    // Sort the array first otherwise finding the overlappings will be O(n^2)
    // Easy way to sort 2d array
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    // sorting using camparator
    // Comparator<int[]> c = (a, b) -> {
    // if (a[0] > b[0])
    // return 1;
    // else if (a[0] < b[0])
    // return -1;
    // else
    // return 0;
    // };
    // Arrays.sort(intervals, c);

    int j = 0;
    int i = 1;
    int count = 0;
    while (i < intervals.length) {
      if (intervals[i][0] <= intervals[j][1]) {
        if (intervals[i][0] < intervals[j][0]) {
          intervals[j][0] = intervals[i][0];
        }
        count = count + 1;

        intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
      } else {
        j++;
        if (j < i) {
          intervals[j][0] = intervals[i][0];
          intervals[j][1] = intervals[i][1];
        }
      }
      i++;
    }
    // System.out.println(Arrays.deepToString(intervals));
    return Arrays.copyOfRange(intervals, 0, intervals.length - count);
  }

  public static void main(String[] args) {
    int[][] intervals = { { 1, 4 }, { 0, 1 } };
    // Arrays.sort(intervals);

    System.out.println(Arrays.deepToString(intervals));
    System.out.println(Arrays.deepToString(merge(intervals)));
  }
}
