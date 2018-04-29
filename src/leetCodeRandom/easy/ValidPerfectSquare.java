package leetCodeRandom.easy;
//https://leetcode.com/problems/valid-perfect-square/description/
public class ValidPerfectSquare {

  public static void main(String[] args) {
    //int num = Integer.MAX_VALUE;
    int num = 808201;
    if (num == 1) {
      System.out.println(1);
    } else {
      int left = 1;
      int right = num / 2;
      int found = -1;
      while (left <= right) {
        int midElem = left + (right - left) / 2;
        System.out.println("Mid Element:" + midElem);
        double value = Math.pow(midElem, 2.0);
        if (value == num) {
          found = midElem;
          break;
        } else if (value < num) {
          left = midElem + 1;
        } else {
          right = midElem - 1;
        }
      }
      System.out.println(found);
    }
  }
}
