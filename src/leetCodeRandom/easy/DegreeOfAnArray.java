package leetCodeRandom.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

  public static void main(String[] args) {
    //int[] nums = {2,2,2,3,1,1,2};
    //int[] nums =  {1,2,3,4,5,6,1};
    int[] nums = {2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2};
    int result = process(nums);
    System.out.println(result);
  }

  private static int process(int[] nums) {
    Map<Integer, int[]> degreeMap = new HashMap<>();
    int minSize = Integer.MAX_VALUE;
    int degree = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (degreeMap.get(nums[i]) == null) {
        int[] value = {1, i, i};
        degreeMap.put(nums[i], value);
      } else {
        int[] value = degreeMap.get(nums[i]);
        value[0]++;
        value[2] = i;
      }
      int[] value = degreeMap.get(nums[i]);
      if (value[0] > degree) {
        degree = value[0];
        minSize = (value[2] - value[1] + 1);
      } else if (value[0] == degree) {
        minSize = Math.min((value[2] - value[1] + 1), minSize);
      }
    }
    return minSize;

  }
}
