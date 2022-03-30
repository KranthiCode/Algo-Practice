package algo.prac.slidingwindow;

public class Housing {
  // Along one side of road there is sequence of vacant plot of land.
  // Each plot has a different area (non-zero),
  // So the areas form a sequence A[1], A[2], ... A[N]

  // You want to buy K acres of land to build a house. You want to find
  // all segments of continguous plots(i.e., a subsection in the sequence)
  // of whose sum is exactly K.

  // a = [1,2,3,4,5]
  // prefix sum array = [1,3,6,10,15] // sum all previous + current element
  // ps(i) = ps(i-1) + a[i]

  // solution one:
  // build prefix sum - O(N)
  // i=0, j=length at each index check ps(j)-ps(i-1) == sum_required
  // O(N^2)

  // solution two:
  // for every i, you find a j such that ps(j)-ps(i)== k (sum_required)
  // since all the array is increasing array so finding j is O(log n)
  // total will be O(n log n)

  // solution three: sliding window
  // ==> maintain a window and store sum of the window
  // maintain current sum such that it's always less than K and if it grows then
  // remove one element from right

  public static void plotAreas(int[] plots, int area) {
    int length = plots.length;
    int i = 0;
    int j = 0;
    int currentSum = 0;
    int smallestWindow = Integer.MAX_VALUE;
    while (j < length) {
      // expand to right
      currentSum = currentSum + plots[j];
      j++;

      while ((currentSum > area) && (i < j)) {
        currentSum = currentSum - plots[i];
        i++;
      }
      if (currentSum == area) {
        System.out.println(i + " - " + (j - 1));
        smallestWindow = smallestWindow < (j - i) ? smallestWindow : (j - i);
      }
    }
    System.out.println("smallest window : " + smallestWindow);
  }

  public static void main(String[] args) {
    int[] plots = { 1, 3, 2, 1, 4, 1, 3, 2, 1, 1 };
    plotAreas(plots, 8);
  }

}
