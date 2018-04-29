package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
public class MoveZeroes {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    //int[] nums = {1, 1, 1, 0, 0, 0};
    //int[] nums = {0,0,0,0,0,1};
    //int[] nums = {0,0,0,0,0,0};
    //int[] nums = {1, 2, 3};
    myApproach(nums);
    mySecondApproach(nums);
    System.out.println(Arrays.toString(nums));
  }

  private static void mySecondApproach(int[] nums) {
    int nonZeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[nonZeroIndex];
        nums[nonZeroIndex] = nums[i];
        nums[i] = temp;
        nonZeroIndex++;
      }
    }
  }

  private static void myApproach(int[] nums) {
    int nonZeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (nums[i] != nums[nonZeroIndex]) {
          nums[nonZeroIndex] = nums[i];
          nums[i] = 0;
        }
        nonZeroIndex++;
      }
    }
  }

}
