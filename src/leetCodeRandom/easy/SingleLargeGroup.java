package leetCodeRandom.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-83/problems/positions-of-large-groups/
public class SingleLargeGroup {

  public static void main(String[] args) {
    //String S = "abc";
    //String S = "abcdddeeeeaabbbcd";
    String S = "abbxxxxzzy";
    List<List<Integer>> result = process(S);
    result.forEach(integers -> integers.forEach(System.out::println));
  }

  private static List<List<Integer>> process(String S) {
    List<List<Integer>> result = new ArrayList<>();
    int pointer = 0;
    while (pointer < S.length()) {
      int x = pointer;
      int count = 1;
      pointer++;
      while (pointer < S.length() && S.charAt(pointer) == S.charAt(x)) {
        count++;
        pointer++;
      }
      if (count >= 3) {
        List<Integer> groupPos = new ArrayList<>(2);
        groupPos.add(x);
        groupPos.add(pointer - 1);
        result.add(groupPos);
      }
    }
    return result;
  }
}
