package leetCodeRandom.easy;

//https://leetcode.com/problems/power-of-two/description/
public class PowerOfTwo {

  public static void main(String[] args) {
    int n = 10;
    boolean result = process(n);
    System.out.println(result);
  }

  private static boolean process(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
