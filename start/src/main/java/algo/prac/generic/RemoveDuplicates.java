package algo.prac.generic;

public class RemoveDuplicates {
  public static void main(String[] args) {
    int[] nums = { 0, 0, 1, 1, 2, 3 };
    System.out.println("count " + removeDuplicates(nums));

    for (int i : nums) {
      System.out.println(i);
    }
  }

  private static int removeDuplicates(int[] nums) {
    int count = 1;
    int currentIndex = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        System.out.println("visiting i, j " + i + "," + j);
        if (nums[i] != nums[j]) {
          System.out.println("i != j >> " + nums[i] + " != " + nums[j]);
          nums[currentIndex] = nums[j];
          currentIndex++;
          count++;
          i = j - 1;
          break;
        }
      }
    }
    return count;
  }
}
