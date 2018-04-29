//https://leetcode.com/problems/detect-capital/description/
package leetCodeRandom.easy;

public class DetectCapital {
  public static void main(String[] args) {
    String input = "F";
    Boolean result = process(input);
    System.out.println(result);
  }

  private static boolean process(String input) {
    if(input.length() == 1){
      return true;
    }
    char[] inputArray = input.toCharArray();
    if(Character.isLowerCase(inputArray[0])){
      // check for only lower index = 1
      for (int i = 1; i < input.length() ; i++){
        if(Character.isUpperCase(inputArray[i])){
          return false;
        }
      }
    }
    if(Character.isUpperCase(inputArray[0])){
      // check for only capital or all small from index = 1
      if(Character.isLowerCase(inputArray[1])){
        // all should be small
        for (int i = 2; i < input.length() ; i++){
         if(Character.isUpperCase(inputArray[i])){
           return false;
         }
        }
      }else {
        // all should be caps
        for (int i = 2; i < input.length() ; i++){
          if(Character.isLowerCase(inputArray[i])){
            return false;
          }
        }
      }
    }
    return true;
  }
}
