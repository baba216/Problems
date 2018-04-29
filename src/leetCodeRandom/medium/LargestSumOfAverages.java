package leetCodeRandom.medium;

import java.util.Arrays;

public class LargestSumOfAverages {

  public static void main(String[] args) {
    int[] A = {9,1,2,3,9};
    int k = 1;
    double result = process(A, k);
    System.out.println(result);
  }

  private static double process(int[] A, int k) {
    if (k == 1) {
      int sum = 0;
      for (int i = 0; i < A.length; i++) {
        sum += A[i];
      }
      return sum;
    }
    Arrays.sort(A);
    double maxAvg = 0;
    for (int i = (A.length - 1); i >= 1; i--) {
      k--;
      maxAvg += A[i];
      if (k == 1) {
        int remainingSum = 0;
        int size = 0;
        for (int j = i - 1; j >= 0; j--) {
          remainingSum += A[j];
          size++;
        }
        maxAvg += (remainingSum / size);
        break;
      }
    }
    return maxAvg;
  }
}
