package dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    long[] c = new long[m];
    for (int c_i = 0; c_i < m; c_i++) {
      c[c_i] = in.nextLong();
    }
    long ways = getWays(n, c);
    System.out.println("Ways:" + ways);
  }

  private static long getWays(int n, long[] c) {
    long[][] coinChange = new long[51][n + 1];
    Arrays.sort(c);
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < c.length; j++) {
        long coin = c[j];
        long maxCoinRequired = i / coin;
        while (maxCoinRequired != 0) {
          long remainder = i - (maxCoinRequired * coin);
          long result = checkWithOtherDenomition(coinChange, c, remainder, coin);
          setValue(coinChange, i, coin, result);
          //display(coinChange);
          maxCoinRequired--;
        }
      }
    }
    long result = 0;
    for (int i = 0; i < c.length; i++) {
      result += coinChange[(int) c[i]][n];
    }
    return result;
  }

  private static void setValue(long[][] coinChange, int n, long coin, long result) {
    coinChange[(int) coin][n] += result;
  }

  private static long checkWithOtherDenomition(long[][] coinChange, long[] coins, long remainder,
      long coin) {
    if (remainder == 0) {
      return 1;
    } else {
      long total = 0;
      for (int i = 0; i < coins.length; i++) {
        if (coins[i] < coin) {
          total += coinChange[(int) coins[i]][(int) remainder];
        } else {
          break;
        }
      }
      return total;
    }
  }

  private static void display(int[][] coin) {
    System.out.println("===Display===");
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 5; j++) {
        System.out.print(" " + coin[i][j]);
      }
      System.out.println();
    }
  }
}
