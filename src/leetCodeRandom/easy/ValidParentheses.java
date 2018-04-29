package leetCodeRandom.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {

  public static void main(String[] args) {
    String input = "[])";
    boolean valid = process(input);
    System.out.println(valid);
  }

  private static boolean process(String input) {
    Stack<Character> openBrackets = new Stack<>();
    openBrackets.push(input.charAt(0));
    Map<Character,Character> bracketsCombination = new HashMap<>(3);
    bracketsCombination.put('}','{');
    bracketsCombination.put(')','(');
    bracketsCombination.put(']','[');
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
        openBrackets.push(input.charAt(i));
      } else {
        if(openBrackets.empty() || !bracketsCombination.get(input.charAt(i)).equals(openBrackets.pop())){
          return false;
        }
      }
    }
    return openBrackets.empty();
  }


}
