package leetCodeRandom.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PlusOne {

  public static void main(String[] args) {
    //int[] digits = {9, 9, 9};
    //int[] digits = {0};
    //int[] digits = {1,9};
    int[] digits = {9,9};
    int[] result = firstApproach(digits);
    System.out.println(Arrays.toString(result));
  }

  private static int[] firstApproach(int[] digits) {
    int lastDigitSum = digits[digits.length - 1] + 1;
    List<Integer> sum = new LinkedList<>();
    int carryOver = 0;
    if (lastDigitSum > 9) {
      int remainder = lastDigitSum % 10;
      sum.add(0,remainder);
      carryOver = lastDigitSum / 10;
    }else {
      sum.add(0,lastDigitSum);
    }
    for (int i = digits.length - 2; i >= 0; i--) {
      int individualSum = digits[i] + carryOver;
      if (individualSum > 9) {
        int remainder = individualSum % 10;
        carryOver = individualSum / 10;
        sum.add(0,remainder);
      } else {
        sum.add(0,individualSum);
        carryOver = 0;
      }
    }
    if(carryOver != 0){
      sum.add(0,carryOver);
    }
    int[] result = new int[sum.size()];
    int i = 0;
    for(Integer element: sum){
      result[i] = element;
      i++;
    }
    return result;
  }
  
}
