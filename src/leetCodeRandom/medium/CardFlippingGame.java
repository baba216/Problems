package leetCodeRandom.medium;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/card-flipping-game/description/
public class CardFlippingGame {

  public static void main(String[] args) {
    int[] fronts = {1,2,4,4,7};
    int[] backs = {1,3,4,1,3}; //output=2*/
    /*int[] fronts = {1,2,3,4,5};
    int[] backs = {5,4,3,2,1};*/ //output = 0
 /*   int[] fronts = {1,1,1,1,1,1};
    int[] backs = {5,5,5,5,5,5};*/
/*    int[] fronts = {1,2,3,4,5,6};
    int[] backs = {1,2,3,4,5,6}; //output = 0*/
    /*int[] fronts = {1,1};
    int[] backs = {2,1};*/ //ouptut : 2*/
    /*int[] fronts = {1,1,1,1,1,1};
    int[] backs = {5,5,5,5,5,3}; output = 0*/
    int result = process(fronts, backs);
    System.out.println(result);
  }

  private static int process(int[] fronts, int[] backs) {
    Set<Integer> same = new HashSet<>();
    for (int i = 0; i < fronts.length; i++) {
      if(fronts[i] == backs[i]){
        same.add(fronts[i]);
      }
    }
    int smallestX = 2001;
    for (int i = 0; i < fronts.length; i++) {
      if (!same.contains(fronts[i])) {
        smallestX = Math.min(fronts[i], smallestX);
      }
      if (!same.contains(backs[i])) {
        smallestX = Math.min(backs[i], smallestX);
      }
    }
    return smallestX % 2001;
  }
}
