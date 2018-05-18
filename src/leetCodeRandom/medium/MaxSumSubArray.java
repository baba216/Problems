package leetCodeRandom.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSumSubArray {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int r = Integer.parseInt(reader.readLine());
    int c = Integer.parseInt(reader.readLine());
    int[][] input = new int[r][c];
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        input[i][j] = Integer.parseInt(tokenizer.nextToken());
      }
    }
    int result = process(input,r,c);
    System.out.println(result);
  }

  private static int process(int[][] input, int r, int c) {
   return 0;
  }
}
