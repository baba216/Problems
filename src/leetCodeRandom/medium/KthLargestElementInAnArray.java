package leetCodeRandom.medium;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInAnArray {

  public static void main(String[] args) {
    int k = 2;
    int[] nums = {3, 2, 1, 5, 6, 4};
    //int[] nums = {2,1,5};
    //int[] nums = {2,1};
    int result = process(nums, k);
    System.out.println(result);
  }

  private static int process(int[] nums, int k) {
    quickSortPartition(nums, 0, nums.length - 1, k);
    return nums[nums.length - k];
  }

  private static boolean quickSortPartition(int[] nums, int start, int end, int k) {
    if (start < end) {
      int partitionIndex = partition(nums, start, end);
      if (partitionIndex == (nums.length - k)) {
        return Boolean.TRUE;
      }
      return quickSortPartition(nums, start, partitionIndex - 1, k) || quickSortPartition(nums,
          partitionIndex + 1, end, k);
    }
    return false;
  }

  private static int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int finalPivotIndex = start;
    for (int i = start; i < end; i++) {
      if (nums[i] < pivot) {
        if (nums[i] != nums[finalPivotIndex]) {
          // do a swap
          int temp = nums[finalPivotIndex];
          nums[finalPivotIndex] = nums[i];
          nums[i] = temp;
        }
        finalPivotIndex++;
      }
    }
    int swapHolder = nums[finalPivotIndex];
    nums[finalPivotIndex] = nums[end];
    nums[end] = swapHolder;
    return finalPivotIndex;
  }
}
