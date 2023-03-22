package algo.prac.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

  // Subsets unique elements
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    subsetsBackTrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void subsetsBackTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      subsetsBackTrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  // Subsets with duplicates
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    subsetsWithDupBacktrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private void subsetsWithDupBacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    list.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1])
        continue; // skip duplicates
      tempList.add(nums[i]);
      subsetsWithDupBacktrack(list, tempList, nums, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

  // for unique elements
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums); // not necessary
    permuteBacktrack(list, new ArrayList<>(), nums);
    return list;
  }

  private void permuteBacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i]))
          continue; // element already exists, skip
        tempList.add(nums[i]);
        permuteBacktrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  // for duplicate elements
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    permuteUniquebacktrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
  }

  private void permuteUniquebacktrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
          continue;
        used[i] = true;
        tempList.add(nums[i]);
        permuteUniquebacktrack(list, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> temp = new ArrayList<>();

      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          temp.add(1);
        } else {
          temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
        }
      }
      result.add(temp);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2 };

  }
}
