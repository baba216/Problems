package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-76/problems/similar-rgb-color/
public class SimilarRGBColor {

  public static void main(String[] args) {
    //String color = "#09f166";
    String color = "#1c9e03";
    Integer red = Integer.parseInt(color.substring(1, 3), 16);
    Integer green = Integer.parseInt(color.substring(3, 5), 16);
    Integer blue = Integer.parseInt(color.substring(5, 7), 16);
    System.out.println("Red:"+red+",Green:"+green+",Blue:"+blue);
    int min = Integer.MIN_VALUE;
    int[] result = new int[3];
    for (int i = 0; i < 256; i += 17) {
      for (int j = 0; j < 256; j += 17) {
        for (int k = 0; k < 256; k += 17) {
          double calc = -1 * Math.pow((red - i), 2.0) - Math.pow((green - j), 2.0) - Math
              .pow((blue - k), 2.0);
          if (calc > min) {
            min = (int) calc;
            result[0] = i;
            result[1] = j;
            result[2] = k;
          }
        }
      }
    }
    System.out.println(Arrays.toString(result));
    String newRed = Integer.toHexString(result[0]);
    String newBlue = Integer.toHexString(result[1]);
    String newGreen = Integer.toHexString(result[2]);
    if (result[0] == 0) {
      newRed += '0';
    }
    if (result[1] == 0) {
      newBlue += '0';
    }
    if (result[2] == 0) {
      newGreen += '0';
    }
    System.out.println("#" + newRed + newBlue + newGreen);
  }
}
