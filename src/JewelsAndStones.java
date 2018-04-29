import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-69/problems/jewels-and-stones/
public class JewelsAndStones {
  public static void main(String[] args) {
    /*String J = "aA";
    String S = "aAAbbbb";*/
    String J = "z";
    String S = "ZZ";
    Set<Character> jewels = new HashSet<>(J.length());
    for (int i = 0; i < J.length(); i++) {
      jewels.add(J.charAt(i));
    }
    int count = 0;
    for (int i = 0; i < S.length(); i++) {
      char stone = S.charAt(i);
      if(jewels.contains(stone)){
        count++;
      }
    }
    System.out.println(count);
  }
}
