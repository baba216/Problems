package dp;
//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {

  public static void main(String[] args) {
    int n = 5;
    int result = process(n);
    System.out.println(result);
  }

  private static int process(int n) {
    int[] steps = new int[n + 1];
    if (n > 0) {
      steps[1] = 1;
      if (n > 1) {
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
          steps[i] = steps[i - 1] + steps[i - 2];
        }
      }
    }
    return steps[n];
  }
}
