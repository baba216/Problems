//https://leetcode.com/problems/array-partition-i/
package leetCodeRandom.easy;

import java.util.Arrays;

public class ArrayPartitionI {

  public static void main(String[] args) {
    //int[] nums = {1, 3, 2, 4};
    int[] nums = {-10000,0,10000,0};
    //int[] nums = {1, 4, 2, 1};
    /*Arrays.sort(nums);
    int minSum = 0;
    for (int i = 0; i < nums.length; i += 2) {
      minSum += nums[i];
    }
    System.out.println(minSum);*/
    secondApproach(nums);
  }

  public static void secondApproach(int[] nums) {
    int[] copyArray = new int[20001];
    for (int i = 0; i < nums.length; i++) {
      copyArray[10000 + nums[i]]++;
    }
    int p = 0;
    int sum = 0;
    for (int i = 0; i < 20001; i++) {
      while (copyArray[i] != 0) {
        copyArray[i]--;
        if (p % 2 == 0) {
          sum += (i - 10000);
        }
        p++;
      }
    }
    System.out.println(sum);
  }

}
