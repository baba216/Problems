package leetCodeRandom.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://leetcode.com/contest/weekly-contest-83/problems/masking-personal-information/
public class MaskingPersonalInformation {

  static Pattern EMAIL_MATCHER = Pattern.compile("[a-zA-Z]{8,}[@][a-zA-Z]{2,}[.][a-zA-Z]{2,}");

  public static void main(String[] args) {
    //String S = "1(234)567-890";
    //String S = "+111 111 111 1111";
    String S = "86-(10)12345678";
    String result = process(S);
    System.out.println(result);
  }

  private static String process(String S) {
    if (S.length() < 8) {
      return null;
    }
    Matcher emailMatcher = EMAIL_MATCHER.matcher(S);
    StringBuilder result = new StringBuilder();

    if (emailMatcher.matches()) {
      int pointer = 0;
      for (int i = 0; i < S.length(); i++) {
        if (S.charAt(i) == '@') {
          result.append(S.charAt(0));
          result.append("******");
          result.append(S.charAt(i - 1));
          pointer = i;
          break;
        }
      }
      for (int i = pointer + 1; i < S.length(); i++) {
        if (Character.isLetter(S.charAt(i))) {
          result.append(Character.toLowerCase(S.charAt(i)));
        } else {
          result.append(S.charAt(i));
        }
      }
    } else {

    }
    return result.toString();
  }
}
