package leetCodeRandom.medium;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {

  public static void main(String[] args) {
    //int[] nums = {1, 1, 1};
    //int[] nums = {2, 2, 2, 2, 2, 6,6};
    //int[] nums = {7,8,2,4,4,5};
    //int[] nums = {1};
    int[] nums = {-1,-1,1};
    int k = 0;
    int result = process(nums, k);
    System.out.println(result);
  }

  private static int process(int[] nums, int k) {
    int sum = 0;
    int lPointer = 0;
    int i = 0;
    int occurrences = 0;
    while (i < nums.length && lPointer < nums.length) {
      int tempSum = nums[i] + sum;
      if (tempSum == k) {
        sum = tempSum;
        occurrences++;
        sum -= nums[lPointer];
        lPointer++;
        i++;
      } else if (tempSum < k) {
        sum = tempSum;
        i++;
      }
      while (tempSum > k && lPointer < nums.length) {
        sum -= nums[lPointer];
        tempSum = sum;
        lPointer++;
      }
    }
    return occurrences;
  }
}
