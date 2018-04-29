package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TilingProblem {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    while (t-- > 0) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(tokenizer.nextToken());
      int m = Integer.parseInt(tokenizer.nextToken());
      int result = process(n, m);
      System.out.println(result);
    }
  }

  private static int process(int n, int m) {
    if (n < m) {
      return 1;
    }
    if (n == m) {
      return 2;
    }
    int[] result = new int[n + 1];
    for (int i = 1; i < m; i++) {
      result[i] = 1;
    }
    result[m] = 2;
    for (int i = m + 1; i <= n; i++) {
      result[i] = result[i - 1] + result[i - m];
    }
    return result[n];
  }
}
