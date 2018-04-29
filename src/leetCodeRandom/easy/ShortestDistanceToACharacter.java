package leetCodeRandom.easy;

import java.util.Arrays;
//https://leetcode.com/contest/weekly-contest-81/problems/shortest-distance-to-a-character/
public class ShortestDistanceToACharacter {

  public static void main(String[] args) {
    /*String S = "loveleetcode";
    char C = 'e';*/

    String S = "aaba";
    char C = 'b';
    int[] output = process(S, C);
    System.out.println(Arrays.toString(output));
  }

  private static int[] process(String S, char C) {
    int prevEPointer = -1;
    int setPointer = 0;
    int[] output = new int[S.length()];
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == C || i == (S.length() - 1)) {
        for (int j = setPointer; j <= i; j++) {
          if (prevEPointer != -1) {
            if (S.charAt(i) == C) {
              output[j] = Math.min(j - prevEPointer, i - j);
            } else {
              output[j] = j - prevEPointer;
            }
          } else {
            output[j] = i - j;
          }
        }
        setPointer = i + 1;
        prevEPointer = i;
      }
    }
    return output;
  }
}
