package dp;

//https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbStairs {

  public static void main(String[] args) {
    //int[] cost = {10, 15, 20};
    int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    int a = cost[0];
    int b = cost[1];
    for (int i = 2; i < cost.length; i++) {
      int c = Math.min(a,b) + cost[i];
      a = b;
      b = c;
    }
    System.out.println(Math.min(a,b));
  }
}
