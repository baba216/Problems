package leetCodeRandom.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/contest/weekly-contest-78/problems/expressive-words/
public class ExpressiveWords {

  public static void main(String[] args) {
    //abbcccaaaa
    //{aabcaa}
    // Note that we cannot extend a group of size one like "h" to a group of size two like "hh" -
    // all extensions must leave the group extended - ie., at least 3 characters long.
    //String S = "heeellooo";
    //String[] words = {"hello", "hi", "helo"};

    /*String S = "aaabcaaa";
    String[] words = {"abc","abca",""};*/
    String S = "aabca";
    String[] words = {"aabca"};
    int result = process(S,words);
    System.out.println(result);
  }

  private static int process(String S, String[] words) {
    int result = 0;
    List<Pair> groups = new LinkedList<>();
    char prevChar = S.charAt(0);
    int prevCharOccurrence = 1;
    for (int i = 1; i < S.length(); i++) {
      char currentChar = S.charAt(i);
      if (currentChar == prevChar) {
        prevCharOccurrence++;
      } else {
        Pair pair = new Pair(prevChar, prevCharOccurrence);
        groups.add(pair);
        prevCharOccurrence = 1;
        prevChar = currentChar;
      }
    }
    groups.add(new Pair(prevChar, prevCharOccurrence));
    for (int i = 0; i < words.length; i++) {
      String input = words[i];
      int inputPointer = 0;
      boolean shouldConsider = Boolean.TRUE;
      for (Pair group : groups) {
        char charToMatchAgainst = group.c;
        int occurrenceInGroup = group.count;
        if(inputPointer >= input.length()){
          shouldConsider = Boolean.FALSE;
          break;
        }
        if (charToMatchAgainst != input.charAt(inputPointer)) {
          break;
        } else {
          int occurrenceInInput = 1;
          for (int j = inputPointer + 1; j < input.length(); j++) {
            if (input.charAt(inputPointer) != input.charAt(j)) {
              break;
            }
            occurrenceInInput++;
          }
          if (occurrenceInInput > occurrenceInGroup) {
            shouldConsider = Boolean.FALSE;
            break;
          }
          if (occurrenceInInput < occurrenceInGroup && occurrenceInGroup == 2) {
            shouldConsider = Boolean.FALSE;
            break;
          }
          inputPointer += occurrenceInInput;
        }
      }
      if (shouldConsider && inputPointer < input.length()) {
        shouldConsider = Boolean.FALSE;
      }
      if (shouldConsider) {
        result++;
      }
    }
    return result;
  }

  private static class Pair{

    char c;
    int count;

    public Pair(char c,int count) {
      this.c = c;
      this.count = count;
    }

    @Override public String toString() {
      return "Pair{" + "c=" + c + ", count=" + count + '}';
    }
  }
}
