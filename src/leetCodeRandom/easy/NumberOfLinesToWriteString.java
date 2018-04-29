package leetCodeRandom.easy;

import java.util.Arrays;

public class NumberOfLinesToWriteString {

  public static void main(String[] args) {
    /*int[] width = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    String s = "abcdefghijklmnopqrstuvwxyz";*/
    int[] width =
        {1, 1, 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10};
    String s = "bbbcccdddaaa";
    int[] result = process(s, width);
    System.out.println(Arrays.toString(result));
  }

  private static int[] process(String S, int[] width) {
    int[] result = new int[2];
    if (S.length() == 0) {
      return result;
    }
    int lines = 1;
    int space = 0;
    for (int i = 0; i < S.length(); i++) {
      int widthRequired = width[S.charAt(i) - 97];
      space += widthRequired;
      if (space > 100) {
        lines++;
        space = widthRequired;
      }
    }
    result[0] = lines;
    result[1] = space;
    return result;
  }
}
