package leetCodeRandom.easy;

import java.util.Objects;

//https://leetcode.com/problems/rotate-string/description/
public class RotateString {

  public static void main(String[] args) {
    String A = "abcde";
    String B = "cdeab";
    /*String A = "slqhrmnxqjtyzvfldllvixbzpswspednzonqkjrlaltguusdxvknoasahjgqdquinucpmlxtdzpnmvxqtfwmxdqozgmaaycjebjs";
    String B = "llvixbzpswspednzonqkjrlaltguusdxvknoasahjgqdquinucpmlxtdzpnmvxqtfwmxdqozgmaaycjebjsslqhrmnxqjtyzvfld";*/
    String C = A+A;
    System.out.println(C);
    Boolean result = process(A, B);
    Boolean result2 = secondApproach(A,B);
    System.out.println(result2);
  }

  private static Boolean secondApproach(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }

  private static Boolean process(String a, String b) {
    if (a.length() != b.length()) {
      return Boolean.FALSE;
    }
    if (Objects.equals(a, b)) {
      return Boolean.TRUE;
    }
    int aPointer = 0;
    for (int bPointer = 0; bPointer < b.length(); bPointer++) {
      if (b.charAt(bPointer) == a.charAt(aPointer)) {
        boolean result = breakProcess(a, b, bPointer, aPointer);
        if (result) {
          return true;
        } else {
          aPointer = 0;
        }
      }
    }
    return Boolean.FALSE;
  }

  private static boolean breakProcess(String a, String b, int bPointer, int aPointer) {
    aPointer++;
    bPointer++;
    while (bPointer < b.length()) {
      if (b.charAt(bPointer) != a.charAt(aPointer)) {
        return Boolean.FALSE;
      }
      bPointer++;
      aPointer++;
    }
    bPointer = 0;
    while (aPointer < a.length()) {
      if(a.charAt(aPointer) != b.charAt(bPointer)){
            return false;
      }
      aPointer++;
      bPointer++;
    }
    return Boolean.TRUE;
  }
}
