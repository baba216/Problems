package leetCodeRandom.easy;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordInAString {

  public static void main(String[] args) {
    String input = "Let's take LeetCode contest";
    //String result = firstApproach(input);
    String result1 = secondApproach(input);
    String result = thirdApproach(input);
  }

  private static String thirdApproach(String s) {
      char[] input =  s.toCharArray();
      int i = 0;
      while (i < input.length){
        int space = s.indexOf(' ',i);
        if(space == -1){

        }
      }
      return s;
  }

  private static String secondApproach(String input) {
    StringBuilder result = new StringBuilder(input.length());
    for (int i = 0; i < input.length(); i++) {
      int start = i;
      while (i < input.length() && !Character.isSpaceChar(input.charAt(i))) {
        i++;
      }
      for (int j = i - 1; j >= start; j--) {
        result.append(input.charAt(j));
      }
      if (i != (input.length() - 1)) {
        result.append(" ");
      }
    }
    System.out.println(result.toString());
    return result.toString();
  }

  private static String firstApproach(String input) {
    String[] words = input.split(" ");
    StringBuilder result = new StringBuilder(input.length());
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      StringBuilder reverseWord = new StringBuilder(word.length());
      for (int j = word.length() - 1; j > -1; j--) {
        reverseWord.append(word.charAt(j));
      }
      if (i != words.length - 1) {
        reverseWord.append(" ");
      }
      result.append(reverseWord);
    }
    return result.toString();
  }

}
