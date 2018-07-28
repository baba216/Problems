package leetCodeRandom.easy;

//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        //int[] nums = {2, 6, 4, 8, 10, 9, 15};
        //int[] nums = {1,2,9,7,6,3};
        //int[] nums = {1,2,3,4};
        int[] nums = {1,3,4,5,6,2};
        int result = process(nums);
        System.out.println(result);
    }

    private static int process(int[] nums) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        //int minLength = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                /*if (minLength > 0 && minLength > (end - start + 1)) {
                    minLength = end - start + 1;
                }*/
                continue;
            }
            if (start == Integer.MAX_VALUE) {
                start = i - 1;
            }
            end = i;
        }
        System.out.println("Start:" + start);
        System.out.println("End:" + end);
        return start == Integer.MAX_VALUE ? 0 : end - start + 1;
    }
}
