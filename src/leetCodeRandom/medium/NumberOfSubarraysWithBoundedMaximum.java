package leetCodeRandom.medium;

public class NumberOfSubarraysWithBoundedMaximum {

  public static void main(String[] args) {
    int[] A = {2,1,4,3};
    //int[] A = {2, 0, 11, 3, 0};
    int L = 2;
    int R = 3;
    // output = 22
    /*int[] A = {73,55,36,5,55,14,9,7,72,52};
    int L = 32;
    int R = 69;*/
    /*int[] A = {16, 69, 88, 85, 79, 87, 37, 33, 39, 34};
    int L = 55;
    int R = 57;*/
    int result = process(A, L, R);
    System.out.println(result);
  }

  private static int process(int[] a, int l, int r) {
    int result = 0;
    int exec = 0;
    int inc = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > r) {
        result += (countSubArray(inc) - countSubArray(exec));
        inc = 0;
        exec = 0;
      } else if (a[i] < l) {
        System.out.println("A[i]"+a[i]+"inc"+inc+"exec:"+exec);
        exec++;
        inc++;
      } else {
        result -= countSubArray(exec);
        exec = 0;
        inc++;
      }
    }
    result += (countSubArray(inc) - countSubArray(exec));
    return result;
  }

  private static int countSubArray(int n) {
    return (n * (n + 1)) / 2;
  }
}
