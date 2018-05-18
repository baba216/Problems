package leetCodeRandom.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
/*    String S = "ADOBECODEBANC";
    String t = "ABC";*/
/*    String S = "of_characters_and_as";
    String t = "aas";*/

    /*String S = "axba";
    String t = "ab";*/

    String S = "efabacdlmn";
    String t = "abcd";
    String result = process(S, t);
    System.out.println(result);
  }

  private static String process(String S, String t) {
    if (S.length() < t.length()) {
      return "";
    } else {
      HashSet<Character> characters = new HashSet<>();
      for (int i = 0; i < t.length(); i++) {
        characters.add(t.charAt(i));
      }
      String result = "";
      int pointer = 0;
      while (pointer < S.length()) {
        boolean matchFound = false;
        int maxStart = Integer.MAX_VALUE;
        HashMap<Character, Integer> characterPosMap = new HashMap<>();
        while (pointer < S.length()) {
          char c = S.charAt(pointer);
          if (characters.contains(c)) {
            if (maxStart == Integer.MAX_VALUE) {
              maxStart = pointer;
            }
            if (characterPosMap.containsKey(c)) {
              int prevPos = characterPosMap.get(c);
              if (prevPos < maxStart) {
                maxStart = pointer;
              }
            }
            characterPosMap.put(c, pointer);
          }
          if (characterPosMap.size() == characters.size()) {
            matchFound = true;
            break;
          }
          pointer++;
        }
        if (matchFound && maxStart != Integer.MAX_VALUE) {
          String tempResult = S.substring(maxStart, pointer + 1);
          System.out.println(tempResult);
          if (Objects.equals(result, "") || tempResult.length() < result.length()) {
            result = tempResult;
          }
        }
      }
      return result;
    }
  }
}
