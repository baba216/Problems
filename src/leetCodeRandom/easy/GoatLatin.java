package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-82/problems/goat-latin/
public class GoatLatin {

  public static void main(String[] args) {
    //String S = "I speak Goat Latin";
    String S ="The quick brown fox jumped over the lazy dog";
    String result = process(S);
    System.out.println(result);
  }

  private static String process(String S) {
    String[] words = S.split(" ");
    StringBuilder result = new StringBuilder();
    StringBuilder aAppender = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      String currentWord = words[i];
      aAppender.append('a');
      if (currentWord.charAt(0) == 'A' || currentWord.charAt(0) == 'a'
          || currentWord.charAt(0) == 'E' || currentWord.charAt(0) == 'e'
          || currentWord.charAt(0) == 'I' || currentWord.charAt(0) == 'i'
          || currentWord.charAt(0) == 'O' || currentWord.charAt(0) == 'o'
          || currentWord.charAt(0) == 'U' || currentWord.charAt(0) == 'u') {
        result.append(currentWord).append("ma").append(aAppender);
      } else {
        String newWord = currentWord.substring(1, currentWord.length());
        result.append(newWord).append(currentWord.charAt(0)).append("ma").append(aAppender);
      }
      if(i != words.length - 1) {
        result.append(" ");
      }
    }
    return result.toString();
  }
}
