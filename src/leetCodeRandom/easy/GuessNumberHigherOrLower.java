package leetCodeRandom.easy;
//https://leetcode.com/problems/guess-number-higher-or-lower/description/
public class GuessNumberHigherOrLower {

  public static void main(String[] args) {
      int n = 10;
      process(n);
  }

  // binary search
  private static void process(int n) {
    int[] nums = new int[n];
    for (int i = 0; i < nums.length; i++) {
        nums[i] = (i+1);
    }
    int left = 0;
    int right = n-1;
    int found = -1000;
    while (left < right){
      int mid = left + (right-left)/2;
      int guessNumber = nums[mid];
    }
  }
}
