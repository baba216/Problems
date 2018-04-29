package self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
public class MaxDifferenceBetweenTwoElem {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = tokenizer.countTokens();
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(tokenizer.nextToken());
    }
    int result = firstApproach(input, n);
    System.out.println(result);
  }

  private static int firstApproach(int[] input, int n) {
    int maxIndex = n - 1;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      if (input[i] > max) {
        max = input[i];
        maxIndex = i;
      }
      if (input[i - 1] < min && (i - 1) < maxIndex) {
        min = input[i - 1];
      }
    }
    return (max - min);
  }

  private static int secondApproach(int[] input, int n) {
    int diff = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < input.length; i++) {
      if (input[i] < min){
        min = input[i];
      }
      if(input[i] - min > diff){
        diff = input[i] - min;
      }
    }
    return diff;
  }
}
