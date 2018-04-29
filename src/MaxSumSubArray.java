public class MaxSumSubArray {

  public static void main(String[] args) {
    //int[] input = {1,2,3,4,5,6};
    //int[] input = {-2,-3,4,-1,-2,1,5,-3};
    int[] input = {-2,-3,4,-1,-2,1,5,-8,9,10};
    int n = input.length;
    int tempSum = input[0];
    int start = 0;
    int end = 0;
    int maxSum = input[0];
    int count = 0;
    for (int i = 1; i < n; i++) {
      count++;
      if(tempSum + input[i] > input[i]){
        tempSum += input[i];
      }else {
        tempSum = input[i];
        count = 0;
      }
      if(tempSum > maxSum){
        maxSum = tempSum;
        end = i;
        start = i-count;
      }
    }
    System.out.println("Max Sum:"+maxSum + ", Start:"+start + ", End:"+end);
  }

  private int secondApproach(int[] nums){
    if (nums == null || nums.length == 0)  return 0;
    int sum=nums[0];
    int max=nums[0];
    for(int i=1;i<nums.length;i++){
      if(sum<0) sum=nums[i];
      else sum+=nums[i];
      max=Math.max(max,sum);
    }
    return max;
  }
}
