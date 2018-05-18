package leetCodeRandom.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
public class MinimumIndexSumOfTwoList {

  public static void main(String[] args) {
    /*String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};*/
    /*String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"KFC", "Shogun", "Burger King"};*/
    String[] list1 = {"ABC","EFG","IJK","KFC"};
    String[] list2 = {"EFG","ABC"};
    String[] result = process(list1, list2);
    System.out.println(Arrays.toString(result));
  }

  private static String[] process(String[] list1, String[] list2) {
    if (list1.length > list2.length) {
      return process(list2, list1);
    }
    Map<String, Integer> restaurantMap = new HashMap<>(list1.length);
    for (int i = 0; i < list1.length; i++) {
      restaurantMap.put(list1[i], i);
    }
    String[] result = new String[list2.length];
    int resultPointer = 0;
    int arrayPointer = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list2.length; i++) {
      String restaurant = list2[i];
      Integer indexInFirstList = restaurantMap.get(restaurant);
      if (indexInFirstList != null) {
        int indexSum = i + indexInFirstList;
        if (indexSum < min) {
          min = indexSum;
          result[arrayPointer] = restaurant;
          resultPointer = arrayPointer;
          arrayPointer++;
        } else if (indexSum == min) {
          result[arrayPointer] = restaurant;
          arrayPointer++;
        }
      }
    }
    return Arrays.copyOfRange(result, resultPointer, arrayPointer);
  }
}
