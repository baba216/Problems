package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicateFromSortedArray {

  public static void main(String[] args) {
    int[] input = {1, 2, 2, 3, 3};
    //int[] input = {1, 2, 3};
    //int[] input = {1, 1, 2, 3};
    int result = firstApproach(input);
    System.out.println(result);
  }

  private static int firstApproach(int[] input) {
    int nextUniqueElem = 0;
    int i = 0;
    while (i < (input.length - 1)) {
      boolean readyToMove = Boolean.FALSE;
      int j = i + 1;
      while (j < input.length) {
        if (input[i] != input[j]) {
          readyToMove = Boolean.TRUE;
          break;
        }
        j++;
      }
      if (readyToMove) {
        nextUniqueElem++;
        input[nextUniqueElem] = input[j];
        i = j;
      } else {
        i++;
      }
      System.out.println(Arrays.toString(input));
    }
    return nextUniqueElem + 1;
  }

  private static int secondApproach(int[] input) {
    int i = input.length > 0 ? 1 : 0;
    for (int n : input) {
      if (n > input[i - 1]) {
        input[i++] = n;
      }
    }
    return i;
  }

  private int thridApproach(int[] nums) {
    if (nums.length == 0)
      return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }


}
