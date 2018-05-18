package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = {1, 4, 11, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int[] result = process(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(result));
  }

  private static int[] process(int[] nums1, int m, int[] nums2, int n) {
    int num1P = nums1.length - 1;
    --m;
    --n;
    while (num1P >= 0 && m >= 0 && n >= 0) {
      if (nums1[m] > nums2[n]) {
        nums1[num1P] = nums1[m];
        nums1[m] = 0;
        m--;
      } else {
        nums1[num1P] = nums2[n];
        n--;
      }
      num1P--;
    }
    while (n >= 0){
      nums1[num1P] = nums2[n];
      n--;
      num1P--;
    }
    while (m >= 0){
      nums1[num1P] = nums1[m];
      m--;
      num1P--;
    }
    return nums1;
  }
}
