package leetCodeRandom.easy;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = {1,1};
    boolean result = process(nums);
    System.out.println(result);
  }

  private static boolean process(int[] nums) {
    Set<Integer> numbers = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      numbers.add(nums[i]);
    }
    return numbers.size() != nums.length;
  }

}
