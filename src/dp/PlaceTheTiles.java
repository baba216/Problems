package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaceTheTiles {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    int[] result = new int[n];
    result[0] = 1;
    if(n > 1) {
      result[1] = 2;
      for (int i = 2; i < result.length; i++) {
        result[i] = result[i - 1] + result[i - 2];
      }
    }
    System.out.println("Result:"+result[n-1]);
  }
}
