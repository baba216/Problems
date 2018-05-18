package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-84/problems/flipping-an-image/
public class FlippingAnImage {

  public static void main(String[] args) {
    //int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
    int[][] A = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
    //int[][] A = {{0}};
    // a
    // result
    for (int i = 0; i < A.length; i++) {
      System.out.println(Arrays.toString(A[i]));
    }
    int[][] result = process(A);
    System.out.println("===");
    // result
    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

  private static int[][] process(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      int lPointer = 0;
      int rPointer = A[i].length - 1;
      if (A[i].length >= 1) {
        for (int j = 0; j < (A[i].length) / 2; j++) {
          if (A[i][rPointer] == A[i][lPointer]) {
            A[i][rPointer] = A[i][rPointer] == 1 ? 0 : 1;
            A[i][lPointer] = A[i][lPointer] == 1 ? 0 : 1;
          }
          rPointer--;
          lPointer++;
        }
        if ((A.length % 2) != 0) {
          A[i][A.length / 2] = A[i][A.length / 2] == 1 ? 0 : 1;
        }
      }
    }
    return A;
  }
}
