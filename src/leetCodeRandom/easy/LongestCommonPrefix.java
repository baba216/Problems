package leetCodeRandom.easy;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
public class LongestCommonPrefix {

  public static void main(String[] args) {
/*    Input: ["flower","flow","flight"]
    Output: "fl"*/
    String[] input = {"flower", "flow", "flight"};
    //String[] input = {"dog","racecar","car"};
    //String[] input = {"a"};
    //String[] input = {"aa","a"};
    //String[] input = {"c","acc","ccc"};
    //String result = process(input);
    String result = bestApproach(input);
    System.out.println(result);
  }

  private static String bestApproach(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String minString = strs[0];
    int minIndex = 0;
    for (int i = 1; i < strs.length; i++) {
      if (minString.length() > strs[i].length()) {
        minString = strs[i];
        minIndex = i;
      }
    }
    for (int i = 0; i < strs.length; i++) {
      if (i != minIndex) {
        while (minString.length() > 0 && strs[i].indexOf(minString, 0) != 0) {
          minString = minString.substring(0, minString.length() - 1);
        }
      }
      if (minString.length() == 0) {
        break;
      }
    }
    return minString;
  }

  private static String process(String[] strs) {
    if (strs == null || strs.length == 0 || strs[0].length() == 0) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    int ix = 0;
    while (ix < strs[0].length()) {
      char x = strs[0].charAt(ix);
      boolean found = true;
      for (int i = 1; i < strs.length; i++) {
        if (ix >= strs[i].length() || x != strs[i].charAt(ix)) {
          found = false;
          break;
        }
      }
      if (found) {
        result.append(x);
      } else {
        break;
      }
      ix++;
    }
    return result.toString();
  }
}
