package leetCodeRandom.easy;

//https://leetcode.com/problems/missing-number/description/
public class MissingNumber {

  public static void main(String[] args) {
    int[] nums = {3,0,1};
    //int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    int result = secondApproach(nums);
    System.out.println(result);
  }

  private static int firstApproach(int[] nums) {
    long sum = (nums.length * (nums.length + 1)) / 2;
    for (int i = 0; i < nums.length; i++) {
      sum -= (long) nums[i];
    }
    return (int) sum;
  }

  private static int secondApproach(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; i++) {
      result ^= i;
      result ^= nums[i];
    }
    return result;
  }
}
