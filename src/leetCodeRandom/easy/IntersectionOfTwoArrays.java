package leetCodeRandom.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/submissions/detail/152344207/
public class IntersectionOfTwoArrays {

  public static void main(String[] args) {
/*    int[] nums1 = {1,2,3,4,5};
    int[] nums2 = {1,2};*/
    int[] nums1 = {};
    int[] nums2 = {};
    //int[] result = myApproach(nums1, nums2);
    int[] result = bestApproach(nums1, nums2);
    System.out.println(Arrays.toString(result));
  }

  private static int[] bestApproach(int[] nums1, int[] nums2) {
    if(nums1.length == 0 || nums2.length == 0){
      return new int[0];
    }
    if (nums1.length < nums2.length) {
      return bestApproach(nums2, nums1);
    }
    int min = nums1[0];
    int max = nums1[0];
    for (int i = 0; i < nums1.length; i++) {
      min = Math.min(min, nums1[i]);
      max = Math.max(max, nums1[i]);
    }
    boolean[] hash = new boolean[(max - min + 1)];
    for (int i = 0; i < nums1.length; i++) {
      int index = nums1[i] - min;
      hash[index] = true;
    }
    int[] result = new int[Math.min(max-min+1,nums2.length)];
    int pointer = 0;
    for (int num : nums2) {
      if (num < min || num > max) {
          continue;
      }
      int index = num - min;
      if(hash[index]){
        hash[index] = false;
        result[pointer] = num;
        pointer++;
      }
    }
    return Arrays.copyOf(result,pointer);
  }

  private static int[] myApproach(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int[] master = nums1;
    int[] slave = nums2;
    if (nums1.length < nums2.length) {
      master = nums2;
      slave = nums1;
    }
    int iPointer = 0;
    int jPointer = 0;
    Set<Integer> intersections = new HashSet<>();
    while (iPointer < master.length && jPointer < slave.length) {
      if (master[iPointer] == slave[jPointer]) {
        intersections.add(master[iPointer]);
        iPointer++;
        jPointer++;
      } else if (master[iPointer] > slave[jPointer]) {
        jPointer++;
      } else {
        iPointer++;
      }
    }
    int[] result = new int[intersections.size()];
    int i = 0;
    for (int x : intersections) {
      result[i] = x;
      i++;
    }
    return result;
  }
}
