package algo.prac.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllPermutations {

  // n! permuations for n elements
  // with extra space complexity
  private static void recursionPremuteWithDS(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
    if (ds.size() == nums.length) {
      System.out.println(ds.toString());
      ans.add(new ArrayList<>(ds));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!freq[i]) {
        freq[i] = true;
        ds.add(nums[i]);
        recursionPremuteWithDS(nums, ds, ans, freq);
        ds.remove(ds.size() - 1);
        freq[i] = false;
      }
    }

  }

  private static void recusionPermute(int[] nums, int index, List<List<Integer>> ans) {
    if (index == nums.length) {
      ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
      System.out.println(ans.get(ans.size() - 1).toString());
      return;
    }
    for (int temp = index; temp < nums.length; temp++) {
      swapPositionsInIntArray(nums, index, temp);
      recusionPermute(nums, index + 1, ans);
      swapPositionsInIntArray(nums, index, temp);
    }
  }

  private static void swapPositionsInIntArray(int[] arr, int i, int j) {
    // if (i == j)
    // return;
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void permutationsIpOp(String ip, String op) {
    if (ip.equals("")) {
      System.out.println(op);
      return;
    }
    for (int i = 0; i < ip.length(); i++) {
      char ch = ip.charAt(i);
      String left = ip.substring(0, i);
      String right = ip.substring(i + 1);
      String result = left + right;
      // System.out.println("op - " + op + ", ip - " + ip + ", left - " + left + ",
      // right - " + right);
      permutationsIpOp(result, op + ch);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };
    boolean[] freq = new boolean[arr.length];
    recursionPremuteWithDS(arr, new ArrayList<>(), new ArrayList<List<Integer>>(), freq);
    recusionPermute(arr, 0, new ArrayList<>());
    permutationsIpOp("abc", "");

    String s = "kranthi";
    System.out.println(s.substring(1));
  }

}
