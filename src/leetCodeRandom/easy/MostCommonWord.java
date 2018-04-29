package leetCodeRandom.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/contest/weekly-contest-80/problems/most-common-word/
public class MostCommonWord {

  public static void main(String[] args) {
    /*String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};*/
    String paragraph = "Bob";
    String[] banned = {};
    String mostCommonWord = process(paragraph,banned);
    System.out.println(mostCommonWord);
  }

  private static String process(String paragraph, String[] banned) {
    Map<String,Integer> frequencyMap = new HashMap<>();
    Set<String> bannedWord = new HashSet<>(banned.length);
    for (int i = 0; i < banned.length; i++) {
      bannedWord.add(banned[i]);
    }
    String maxOccuringWord = null;
    int maxOccurances = 0;
    Set<Character> punctuations = new HashSet<>();
    punctuations.add('!');
    punctuations.add('?');
    punctuations.add('\'');
    punctuations.add(',');
    punctuations.add(',');
    punctuations.add(';');
    punctuations.add('.');
    int pivot = 0;
    for (int i = 1; i < paragraph.length(); i++) {
      if (punctuations.contains(paragraph.charAt(i)) || paragraph.charAt(i) == ' ' || i == paragraph.length() - 1) {
        String word = paragraph.substring(pivot, i).toLowerCase();
        pivot = i;
        while (pivot < paragraph.length() && !Character.isAlphabetic(paragraph.charAt(pivot))) {
          pivot++;
        }
        if (!bannedWord.contains(word)) {
          Integer occurrences = frequencyMap.getOrDefault(word, 0);
          frequencyMap.put(word, ++occurrences);
          if (occurrences > maxOccurances) {
            maxOccurances = occurrences;
            maxOccuringWord = word;
          }
        }
        i = pivot;
      }
    }
    return maxOccuringWord;
  }
}
