package leetCodeRandom.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class IntersectionOfArrays {

  public static void main(String[] args) {
    /*int[] nums1 = {1,2,2,1};
    int[] nums2 = {2,2};*/
    int[] nums1 = {1,2,2,1};
    int[] nums2 = {1,1,2,2};
    int[] result = process(nums1, nums2);
    System.out.println(Arrays.toString(result));
  }

  private static int[] process(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    //if(nums1.length != nums2.length){}
    int[] masterArray = nums1;
    int[] childArray = nums2;
    if (nums1.length < nums2.length) {
      masterArray = nums2;
      childArray = nums1;
    }
    int i = 0;
    int j = 0;

    List<Integer> result = new ArrayList<>();
    while (i < masterArray.length && j < childArray.length){
      if(masterArray[i] > childArray[j]){
        j++;
      }else if(masterArray[i] < childArray[j]) {
        i++;
      }else {
        result.add(masterArray[i]);
        i++;
        j++;
      }
    }
    int[] arrayResult = new int[result.size()];
    for (int k = 0; k < result.size() ; k++) {
      arrayResult[k] = result.get(k);
    }
    return arrayResult;
  }
}
