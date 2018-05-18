package leetCodeRandom.medium;

//https://leetcode.com/contest/weekly-contest-83/problems/consecutive-numbers-sum/
public class ConsecutiveNumberSum {

  public static void main(String[] args) {
    //int input = 5; // output = 2
    //int input = 15; // output = 4
    int input = 9; //output = 3
    //int result = consecutiveNumberSum(input);
    //int input = 99105; //TLE with brute force
    //int input = 43156417; //TLE with brute force
    //int result1 = bruteForce(21);
    //int result = mathematical(24);
    int result = bestApproach(5);
    System.out.println(result);
  }

  //https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
  private static int bestApproach(int N) {
    while ((N & 1) == 0) {
      N >>= 1;
    }
    int ans = 1;
    int d = 3;
    while (d * d <= N) {
      int e = 0;
      while (N % d == 0) {
        N /= d;
        e++;
      }
      ans *= e + 1;
      d += 2;
    }
    if (N > 1) {
      ans <<= 1;
    }
    return ans;
  }

  private static int mathematical(int input) {
    int result = 0;
    int limit = 2 * input;
    for (int k = 1; k <= limit; k++) {
      if (limit % k == 0) {
        int y = (limit / k) - (k + 1);
        if (y >= 0 && y % 2 == 0) {
          System.out.println(k);
          result++;
        }
      }
    }
    return result;
  }

  private static int bruteForce(int input) {
    int result = 0;
    int lim = input / 2;
    for (int i = 1; i <= lim; i++) {
      int sum = input;
      int start = i;
      while (sum > 0) {
        sum -= start;
        start++;
      }
      if (sum == 0) {
        System.out.println("Start:" + i + ",End:" + start);
        result++;
      }
    }
    return result + 1;
  }

  private static int consecutiveNumberSum(int input) {
    int[] output = new int[input + 1];
    output[1] = 0;
    output[2] = 0;
    for (int num = 3; num <= input; num++) {
      int half = num / 2;
      if (num % 2 != 0) {
        int consecutiveSum = half + (half + 1);
        if (consecutiveSum == num) {
          output[num] = output[half] + output[half + 1] + 1;
        }
      }
      if (output[half] != 0) {
        if (2 * half == num) {
          output[num]++;
        }
      }
    }
    return output[input] + 1;
  }
}
