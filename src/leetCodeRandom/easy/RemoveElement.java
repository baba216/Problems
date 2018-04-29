package leetCodeRandom.easy;

import java.util.Arrays;

public class RemoveElement {

  public static void main(String[] args) {
    //int[] nums = {3, 2, 2, 3};
    //int[] nums = {1,3,2,1,0};
    int[] nums = {3,3,3,3,3,3};
    int val = 3;
    myApproach(nums, val);
    System.out.println(Arrays.toString(nums));
  }

  private static void myApproach(int[] nums, int val) {
    int nonValueIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[nonValueIndex] = nums[i];
        nonValueIndex++;
      }
    }
    System.out.println(nonValueIndex);
  }
}
