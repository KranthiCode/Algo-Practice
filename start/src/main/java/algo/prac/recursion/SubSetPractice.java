package algo.prac.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetPractice {
  // String - duplicates - returns nothing
  static void subSetStrings(String input, String output) {
    if (input.equals("")) {
      System.out.println(output);
      return;
    }
    String subOutput1 = output;
    String subOutput2 = output + input.charAt(0);
    input = input.substring(1);
    subSetStrings(input, subOutput1);
    subSetStrings(input, subOutput2);
  }

  // String - duplicates - returns list of subsets as strings
  static List<String> subSetStrings(String input, String output, List<String> ans) {
    if (input.equals("")) {
      ans.add(output);
      return ans;
    }
    String subOutput1 = output;
    String subOutput2 = output + input.charAt(0);
    input = input.substring(1);
    subSetStrings(input, subOutput1, ans);
    subSetStrings(input, subOutput2, ans);
    return ans;
  }

  // backtracking - method 1
  static void subSetInts(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
    if (index == nums.length) {
      ans.add(temp);
      return;
    }

    subSetInts(nums, ans, new ArrayList<>(temp), index + 1);
    temp.add(nums[index]);
    subSetInts(nums, ans, new ArrayList<>(temp), index + 1);
  }

  // backtracking - method 2
  static void subSetInts2(int[] nums, List<List<Integer>> ans, List<Integer> temp, int start) {
    ans.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      subSetInts2(nums, ans, temp, i + 1);
      temp.remove(temp.size() - 1);
    }

  }

  // Only for loops approach
  public static List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    result.add(tmp); // add empty set
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int n = result.size();
      for (int j = 0; j < n; j++) {
        // NOTE: must create a new tmp object, and add element to it.
        tmp = new ArrayList<Integer>(result.get(j));
        tmp.add(nums[i]);
        result.add(new ArrayList<Integer>(tmp));
      }
    }
    // Alternate to above to just use the previously generated results length
    // for (int i : nums) {
    // for (List<Integer> sub: result) {
    // List<Integer> newList = new ArrayList<>(sub);
    // newList.add(i);
    // result.add(newList);
    // }
    // }
    return result;
  }

  public static void main(String[] args) {
    // subSetStrings("abcd", "");
    List<String> ans;
    ans = subSetStrings("abcd", "", new ArrayList<>());
    // System.out.println(ans.toString());
    int[] arr = { 1, 2, 3, 4 };
    List<List<Integer>> ansints = new ArrayList<>();
    // subSetInts(arr, ansints, new ArrayList<>(), 0);
    // System.out.println(ansints.toString());
    // System.out.println(subsets2(arr).toString());

    subSetInts2(arr, ansints, new ArrayList<>(), 0);
    System.out.println(ansints.toString());
  }
}
