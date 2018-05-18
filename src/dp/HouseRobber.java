package dp;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/
public class HouseRobber {

  public static void main(String[] args) {
    //int[] nums = {5,2,3,8};
    //int[] nums = {1,2,3,1};
    //int[] nums = {2,7,9,3,1};
    int[] nums = {};
    int result = process(nums);
    System.out.println(result);
  }

  private static int process(int[] nums) {
    if(nums == null || nums.length == 0){
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int a = nums[0];
    int b = Math.max(a, nums[1]);
    for (int i = 2; i < nums.length; i++) {
      int c = Math.max((a + nums[i]), b);
      a = b;
      b = c;
    }
    return b;
  }
}
