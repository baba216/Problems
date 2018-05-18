package leetCodeRandom.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/contest/weekly-contest-84/problems/find-and-replace-in-string/
public class FindAndReplaceInString {

  public static void main(String[] args) {
    /*String S = "abcd";
    int[] indexes = {0, 2};
    String[] sources = {"a", "cd"};
    String[] targets = {"eee", "ffff"};
    String[] sources = {"bab", "ec"};
    String[] targets = {"eee", "ffff"};*/
    /*String S = "vyeqmeyggv"; // output: v y e q b q a q q
    int[] indexes = {4, 0, 7};
    String[] sources = {"mey", "vey", "ggv"};
    String[] targets = {"bq", "aa", "aqq"};*/

    String S = "vmokgggqzp"; // output:"vbfrssozp"
    int[] indexes = {3, 5, 1};
    String[] sources = {"kg", "ggq", "mo"};
    String[] targets = {"s", "so", "bfr"};

    //String result = process(S, indexes, sources, targets);
    String result = betterApproach(S,indexes,sources,targets);
    System.out.println(result);
  }

  private static String betterApproach(String S, int[] indexes, String[] sources,
      String[] targets) {
    int N = S.length();
    int[] match = new int[N];// store the index in indexes which matches
    Arrays.fill(match, -1); // why -1, because index can be 0
    for (int i = 0; i < indexes.length; i++) {
      int start = indexes[i];
      int end = indexes[i] + sources[i].length();
      System.out.println("Start:" + start + ",End:" + end + ",Str:" + sources[i]);
      if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) {
        match[indexes[i]] = i;
      }
    }
    int ix = 0;
    StringBuilder builder = new StringBuilder();
    while (ix < S.length()) {
      if (match[ix] >= 0) {
        int index = match[ix];
        String source = sources[index];
        String target = targets[index];
        builder.append(target);
        ix += source.length();
      } else {
        builder.append(S.charAt(ix));
        ix++;
      }
    }
    System.out.println("Result:" + builder);
    return builder.toString();
  }

  /**
   * My Approach
   */
  private static String process(String S, int[] indexes, String[] sources, String[] targets) {
    StringBuilder builder = new StringBuilder(S);
    TreeMap<Integer, Integer> originalIndexMap = new TreeMap<>();
    for (int i = 0; i < indexes.length; i++) {
      String source = sources[i];
      int targetIndex = indexes[i];
      if (S.charAt(targetIndex) == source.charAt(0)) {
        int x = targetIndex + 1;
        boolean found = true;
        for (int j = 1; j < source.length(); j++) {
          if (S.charAt(x) != source.charAt(j)) {
            found = false;
            break;
          }
          x++;
        }
        if (found) {
          originalIndexMap.put(targetIndex, i);
        }
      }
    }
    int diffFactor = 0;
    for (Map.Entry entry : originalIndexMap.entrySet()) {
      int indexInOriginal = (int) entry.getKey() + diffFactor;
      int indexInTarget = (int) entry.getValue();
    builder.replace(indexInOriginal, indexInOriginal + sources[indexInTarget].length(),
          targets[indexInTarget]);
      diffFactor += targets[indexInTarget].length() - sources[indexInTarget].length();
    }
    return builder.toString();
  }


}
