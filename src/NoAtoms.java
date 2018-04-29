import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoAtoms {

  public static void main(String[] args) {
    Date date = new Date(1483271999000L);
    Date date1 = new Date(1483747201000L);
    long interval = date1.getTime() - date.getTime();
    System.out.println(TimeUnit.MILLISECONDS.toDays(interval));
  }

  private static int i = 0;


  public static Map<String, Integer> getCountMap(String formula) {
    int length = formula.length();
    Map<String, Integer> countMap = new TreeMap<>();
    while (i < length && formula.charAt(i) != ')') {
      if (formula.charAt(i) == '(') {
        ++i;
        for (Map.Entry<String, Integer> entry : getCountMap(formula).entrySet()) {
          countMap.put(entry.getKey(), countMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
      } else {
        int iStart = i++;
        while (i < length && Character.isLowerCase(formula.charAt(i))) {
          i++;
        }
        String elemName = formula.substring(iStart, i);
        iStart = i;
        while (i < length && Character.isDigit(formula.charAt(i))) {
          ++i;
        }
        Integer multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
        countMap.put(elemName, countMap.getOrDefault(elemName, 0) + multiplicity);
      }
    }
    int iStart = ++i;
    while (i < length && Character.isDigit(formula.charAt(i))) {
      ++i;
    }
    if (iStart < i) {
      int multiplicity = Integer.parseInt(formula.substring(iStart, i));
      for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
        countMap.put(entry.getKey(), countMap.get(entry.getKey()) * multiplicity);
      }
    }
    return countMap;
  }

  class Solution {

    int i;

    public String countOfAtoms(String formula) {
      StringBuilder ans = new StringBuilder();
      i = 0;
      Map<String, Integer> count = parse(formula);
      for (String name: count.keySet()) {
        ans.append(name);
        int multiplicity = count.get(name);
        if (multiplicity > 1) ans.append("" + multiplicity);
      }
      return new String(ans);
    }

    public Map<String, Integer> parse(String formula) {
      int N = formula.length();
      Map<String, Integer> count = new TreeMap<>();
      while (i < N && formula.charAt(i) != ')') {
        if (formula.charAt(i) == '(') {
          i++;
          for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
            count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
          }
        } else {
          int iStart = i++;
          while (i < N && Character.isLowerCase(formula.charAt(i)))
            i++;
          String name = formula.substring(iStart, i);
          iStart = i;
          while (i < N && Character.isDigit(formula.charAt(i)))
            i++;
          int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
          count.put(name, count.getOrDefault(name, 0) + multiplicity);
        }
      }
      int iStart = ++i;
      while (i < N && Character.isDigit(formula.charAt(i)))
        i++;
      if (iStart < i) {
        int multiplicity = Integer.parseInt(formula.substring(iStart, i));
        for (String key : count.keySet()) {
          count.put(key, count.get(key) * multiplicity);
        }
      }
      return count;
    }

  }
}

