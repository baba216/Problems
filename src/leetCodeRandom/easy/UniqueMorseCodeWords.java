package leetCodeRandom.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

  static String[] codes =
      {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
          "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
          "--.."};

  public static void main(String[] args) {
    String[] words = {"gin","zen","gig","msg"};
    int result = process(words);
    System.out.println(result);
  }

  private static int process(String[] words) {
    Set<String> uniqueTransformation = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      StringBuilder morseBuilder = new StringBuilder();
      for (int j = 0; j < word.length(); j++) {
        String code = codes[word.charAt(j) - 97];
        morseBuilder.append(code);
      }
      uniqueTransformation.add(morseBuilder.toString());
    }
    return uniqueTransformation.size();
  }
}
