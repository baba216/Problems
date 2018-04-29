package leetCodeRandom.easy;
//https://leetcode.com/problems/number-of-1-bits/description/
public class NumberOf1Bits {

  public static void main(String[] args) {
    int n = Integer.parseUnsignedInt("4294967295");
    int result = process(n);
    System.out.println(result);
  }

  private static int process(int n) {
    if (n == 0) {
      return 0;
    } else {
      int result = 0;
      while (n != 0) {
        result = (n & 1) + result;
        n >>>= 1;
      }
      return result;
    }
  }
}
