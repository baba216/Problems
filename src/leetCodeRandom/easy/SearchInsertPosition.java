package leetCodeRandom.easy;

public class SearchInsertPosition {

  public static void main(String[] args) {
    // input 1
    /*int[] nums = {1,3,5,6};
    int target = 5;*/ //output = 2*/
    // input 2
    /*int[] nums = {1,3,5,6};
    int target = 2;*/

    /*int[] nums = {1,3,5,6};
    int target = 7;*/

    int[] nums = {1,3,5,6,7};
    int target = 5;

    //int result = process(nums,target);
    int result = bestApproach(nums,target);
    System.out.println(result);
  }

  private static int bestApproach(int[] nums, int target) {
    int left = 0, right = nums.length-1;
    while(left<=right){
      int mid = (right-left)/2+left;
      if (nums[mid]==target){
        return mid;
      }
      if(nums[mid]>target){
        right=mid-1;
      }else{
        left=mid+1;
      }
    }
    return left;
  }

  private static int process(int[] nums, int target) {
    // find number which is less than or equal to
    int indexLessThanEqualTo = 0;
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        indexLessThanEqualTo = mid;
        break;
      } else if (nums[mid] < target) {
        low = mid + 1;
        indexLessThanEqualTo = mid;
      } else {
        high = mid - 1;
        indexLessThanEqualTo = mid;
      }
    }
    if(nums[indexLessThanEqualTo] >= target){
      return indexLessThanEqualTo;
    }
    return indexLessThanEqualTo + 1;
  }


}
