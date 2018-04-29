package leetCodeRandom.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
public class TwoSum {

  public static void main(String[] args) {
    /*int[] nums = {2, 7, 11, 15};
    int target = 9;*/
    /*int[] nums = {3,3};
    int target = 6;*/
    int[] nums = {3, 2, 4}; //2,3,4
    int target = 6;
    int[] result = process(nums, target);
    System.out.println(Arrays.toString(result));
  }

  private static int[] process(int[] nums, int target) {
    Map<Integer, Integer> complimentLocation = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int compliment = target - nums[i];
      if (complimentLocation.containsKey(compliment)) {
        result[0] = i;
        result[1] = complimentLocation.get(compliment);
        return result;
      }
      complimentLocation.put(nums[i],i);
    }
    throw new IllegalArgumentException("Invalid Input");
  }
}
