package algo.prac.generic;

public class MergeSortedArrays {

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    while (m > 0 || n > 0) {
      if (m > 0 && n > 0) {
        if (nums1[m - 1] > nums2[n - 1]) {
          nums1[m + n - 1] = nums1[m - 1];
          System.out.println("nums1 : m+n-1 >> " + (m + n - 1) + ", num2: m-1 >> " + (m - 1));
          m--;
        } else {
          nums1[m + n - 1] = nums2[n - 1];
          System.out.println("nums1 : m+n-1 >> " + (m + n - 1) + ", num2: m-1 >> " + (n - 1));
          n--;
        }

      }

      else if (m > 0) {
        nums1[m + n - 1] = nums1[m - 1];
        System.out.println("nums1 : m+n-1 >> " + (m + n - 1) + ", num2: m-1 >> " + (m - 1));
        m--;
      } else {
        nums1[m + n - 1] = nums2[n - 1];
        n--;
      }

    }

  }

  public static void main(String[] args) {
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    int[] nums2 = { 1, 2, 3 };
    int m = nums1.length;
    int n = nums2.length;
    merge(nums1, n, nums2, n);

    // for (int i : nums1) {
    // System.out.println(i);
    // }

  }

}
