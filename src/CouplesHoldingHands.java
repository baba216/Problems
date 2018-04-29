import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/weekly-contest-67/problems/couples-holding-hands/
public class CouplesHoldingHands {

  public static void main(String[] args) {
    //int[] row = {0, 2, 1, 3};
    //int[] row = {3, 2, 0, 1};
    //int[] row = {5,4,2,6,3,1,0,7}; //expected:2
    int[] row = {0, 2, 4, 6, 7, 1, 3, 5}; // expected:3
    Map<Integer, Integer> userLocation = new HashMap<>(row.length);
    for (int i = 0; i < row.length; i++) {
      userLocation.put(row[i], i);
    }
    int numberOfSwap = 0;
    for (int i = 0; i < row.length-1; i += 2) {
      if (row[i] % 2 == 0) {
        if (row[i + 1] != row[i] + 1) {
          numberOfSwap++;
          // find for that user and do the changes
          int index = userLocation.get(row[i] + 1);
          row[index] = row[i + 1];
          row[i + 1] = row[i] + 1;
          userLocation.put(row[i + 1], i+1);
          userLocation.put(row[index], index);
        }
      } else {
        if (row[i + 1] != row[i] - 1) {
          numberOfSwap++;
          int index = userLocation.get(row[i] - 1);
          row[index] = row[i + 1];
          row[i + 1] = row[i] -1;
          userLocation.put(row[index],index);
          userLocation.put(row[i+1],i+1);
        }
      }
    }
    System.out.println(numberOfSwap);
  }
}
