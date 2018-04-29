package leetCodeRandom.hard;
// do revise. took help
//https://leetcode.com/problems/first-missing-positive/description/
public class FirstMissingPositive {

  public static void main(String[] args) {
    //int[] nums = {1, 2, 0};
    int[] nums = {3,4,-1,1};
    int result = firstApproach(nums);
    System.out.println(result);
  }

  private static int firstApproach(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
        swap(i,nums);
      }
    }
    int missingNumber = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != (i + 1)) {
        missingNumber = i + 1;
        break;
      }
    }
    return missingNumber;
  }

  private static void swap(int i, int[] nums) {
      int temp = nums[i];
      nums[i] = nums[nums[i]-1];
      nums[temp-1] = temp;
  }
}
