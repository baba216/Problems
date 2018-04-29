//https://leetcode.com/contest/weekly-contest-69/problems/global-and-local-inversions/
public class GlobalAndLocalInversions {

  public static void main(String[] args) {
    //int[] A = {1, 0, 2};
    //int[] A = {1,2,0};
    //int[] A = {2,0,1};
    //int[] A = {0, 2, 3, 1};
    int[] A = {0,2,1};
    for (int i = 1; i < A.length; i++) {
      if(A[i-1] == A[i]+1){
          int temp = A[i];
          A[i] = A[i-1];
          A[i-1] = temp;
      }else if(A[i-1] != i-1){
        System.out.println(Boolean.FALSE);
      }
    }
    System.out.println(Boolean.TRUE);
  }

  public static boolean secondApproach(int[] A) {
    for (int i = 0; i < A.length; ++i)
      if (Math.abs(A[i] - i) > 1)
        return false;
    return true;
  }

  public static boolean isIdealPermutation(int[] A) {
    int cmax = 0;
    for (int i = 0; i < A.length - 2; ++i) {
      cmax = Math.max(cmax, A[i]);
      if (cmax > A[i + 2]) return false;
    }
    return true;
  }
}
