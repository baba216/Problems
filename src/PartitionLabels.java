import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/contest/weekly-contest-67/problems/partition-labels/
public class PartitionLabels {

  public static void main(String[] args) {
    //String s = "ababcbacadefegdehijhklij";
    //String s = "bceacbacdbbadea";
    String s = "qiejxqfnqceocmy";
    //output:[15]
    //Expected:[13,1,1]
    char[] sArray = s.toCharArray();
    int[] lastIndexOfAlphabet = new int[26];
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char currentChar = s.charAt(i);
      int index = ((int) currentChar) - 97;
      lastIndexOfAlphabet[index] = i;
    }
    int index = 0;
    List<Integer> result = new ArrayList<>();
    while (index < length){
      char top = sArray[index];
      int lastOccuranceForTop = lastIndexOfAlphabet[top - 97];
      int limit = lastOccuranceForTop;
      for (int i = index + 1; i < limit; i++) {
          char nextElem = sArray[i];
          int lastIndexForNextCharacter = lastIndexOfAlphabet[nextElem - 97];
          if(lastIndexForNextCharacter > limit){
            limit = lastIndexForNextCharacter;
          }
      }
      int size = limit - index + 1;
      result.add(size);
      index = limit + 1;
      System.out.println("indez:"+index);
    }
    System.out.println(result);
  }

}
