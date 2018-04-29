// https://leetcode.com/contest/weekly-contest-64/problems/largest-number-greater-than-twice-of-others/
public class LargestNumberGreaterThanTwiceOfOthers {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    //int[] nums = {3, 6, 1, 0};
    //int[] nums = {9,1,2,3};
    //int[] nums = {6,6,6};
    //int[] nums = {0};
    //int[] nums = {0,0,0,1};
    //int[] nums = {0,0,0,0,0};
    if(nums.length == 1){
      if(nums[0] != 0) {
        System.out.println(0);
      }else {
        System.out.println(-1);
      }
    }
    int largestNumberIndex = -1;
    int largestNumber = -1;
    int secondLargestNumber = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= largestNumber) {
        secondLargestNumber = largestNumber;
        largestNumber = nums[i];
        largestNumberIndex = i;
      } else if (nums[i] > secondLargestNumber) {
        secondLargestNumber = nums[i];
      }
    }
    if(largestNumber != 0 && secondLargestNumber != 0 && largestNumber/secondLargestNumber >= 2){
      System.out.println(largestNumberIndex);
    }else if(largestNumber != 0 && secondLargestNumber == 0){
      System.out.println(largestNumberIndex);
    }else {
      System.out.println(-1);
    }
  }
}
