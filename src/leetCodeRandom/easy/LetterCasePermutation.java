package leetCodeRandom.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {
  public static void main(String[] args) {
    String input = "a1b2";
    firstApproach(input);
    secondApproach(input);
  }


  private static void firstApproach(String input) {
    List<String> permutations = new LinkedList<>();
    permutations.add(input);
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        continue;
      }
      int size = permutations.size();
      for (int j = 0; j < size; j++) {
        char[] anchorElem = permutations.remove(0).toCharArray();
        // convert character at ith position to upper case
        anchorElem[i] = Character.toUpperCase(anchorElem[i]);
        permutations.add(String.valueOf(anchorElem));
        // convert character at ith position to lower case
        anchorElem[i] = Character.toLowerCase(anchorElem[i]);
        permutations.add(String.valueOf(anchorElem));
      }
    }
    System.out.println(permutations);
  }

  private static void secondApproach(String input) {
    int B = 0;
    for (char c : input.toCharArray()) {
      if (Character.isLetter(c)) {
        B++;
      }
    }
    List<String> ans = new ArrayList<>();
    for (int bits = 0; bits < 1 << B; bits++) {
      int b = 0;
      StringBuilder word = new StringBuilder();
      for (char letter : input.toCharArray()) {
        if (Character.isLetter(letter)) {
          if (((bits >> b++) & 1) == 1) {
            word.append(Character.toLowerCase(letter));
          } else {
            word.append(Character.toUpperCase(letter));
          }
        } else {
          word.append(letter);
        }
      }
      ans.add(word.toString());
    }
    System.out.println(ans);
  }
}
