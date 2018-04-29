//https://leetcode.com/contest/weekly-contest-66/problems/find-anagram-mappings/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMapping {

  public static void main(String[] args) {
    int[] a = {12, 28, 46, 32, 50};
    int[] b = {50, 12, 32, 46, 28};
    int[] result = new int[a.length];
    Map<Integer, Integer> indexMapping = new HashMap<>(b.length);
    for (int i = 0; i < b.length; i++) {
      indexMapping.put(b[i], i);
    }
    for (int i = 0; i < a.length; i++) {
      result[i] = indexMapping.get(a[i]);
    }
    System.out.println(Arrays.toString(result));
  }
}
