import java.util.Arrays;

//https://leetcode.com/articles/find-pivot-index/
public class PivotIndex {

  public static void main(String[] args) {
    //int[] nums = {1, 7, 3, 6, 5, 6};
    //int[] nums = {-1,-1,-1,-1,-1,-1};
    int[] nums = {-1,-1,-1,0,1,1};
    int length = nums.length;
    int[] nums_sum = new int[length];
    nums_sum[0] = nums[0];
    for (int i = 1; i < length ; i++) {
      nums_sum[i] = nums_sum[i-1] + nums[i];
    }
    System.out.println(Arrays.toString(nums_sum));
    int pivot = -1;
    for (int i = 0; i < length; i++) {
      if ((nums_sum[length - 1]) == (2 * nums_sum[i] - nums[i])) {
        pivot = i;
        break;
      }
    }
    System.out.println(pivot);
  }


  /*public int pivotIndex(int[] nums) {

    int sum = 0;
    for(int i=0;i<nums.length;++i){
      sum += nums[i];
    }

    int leftSum = 0;
    for(int i=0;i<nums.length;++i){

      if(leftSum == sum - leftSum - nums[i]) return i;
      leftSum = leftSum + nums[i];
    }

    return -1;

  }*/
}
