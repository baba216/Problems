import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://hack.codingblocks.com/contests/c/204/258
public class CoinChange {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    tokenizer = new StringTokenizer(reader.readLine());
    int[] coins = new int[m];
    for (int i = 0; i < m; i++) {
      coins[i] = Integer.parseInt(tokenizer.nextToken());
    }
    int result = getCoinChangeRecursion(coins, coins.length, n);
    System.out.println(result);
  }

  private static int getCoinChangeRecursion(int[] coins, int m, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (m <= 0) {
      return 0;
    }
    return getCoinChangeRecursion(coins, m - 1, n) + getCoinChangeRecursion(coins, m,
        n - coins[m - 1]);
  }



}
