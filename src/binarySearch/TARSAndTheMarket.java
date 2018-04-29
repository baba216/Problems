//https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/tars-and-the-market-8a58f869/description/
package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TARSAndTheMarket {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int budget = Integer.parseInt(tokenizer.nextToken());
    int[] costs = new int[n+1];
    tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 1; i <= n; i++) {
      costs[i] = Integer.parseInt(tokenizer.nextToken());
    }
    int low = 1;
    int high = n;
    int highestItemCount = 0;
    int highestBudget = 0;
    while(low <= high){
      int itemCount = (low+high)/2;
      int[] costAsPerItemCount = new int[n];
      for (int i = 1 ; i <= n ; i++){
        costAsPerItemCount[i-1] = costs[i] + (i*itemCount);
      }
      System.out.println(Arrays.toString(costAsPerItemCount));
      Arrays.sort(costAsPerItemCount);
      int totalCost = 0;
      for (int i = 0; i < itemCount; i++) {
        totalCost += costAsPerItemCount[i];
        if(totalCost > budget){
          high = itemCount - 1;
          break;
        }
      }
      // if total cost is less than budget, increment lower limit
      if(totalCost <= budget){
        if(highestItemCount < itemCount){
          highestItemCount = itemCount;
          highestBudget = totalCost;
        }
        low = itemCount + 1;
      }
    }
    System.out.println(highestItemCount+" "+highestBudget);
  }
}
