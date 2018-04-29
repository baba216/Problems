package self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://hack.codingblocks.com/dcb/p/89
public class StockBuyAndSell {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(reader.readLine());
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int[] price = new int[n];
      for (int i = 0; i < n; i++) {
        price[i] = Integer.parseInt(tokenizer.nextToken());
      }
      int result = process(price);
      System.out.println(result);
    }
  }

  private static int process(int[] price) {
    int n = price.length;
    int[] sortedPrice = Arrays.copyOf(price, price.length);
    Arrays.sort(sortedPrice);
    long totalProfit = 0;
    int highestPrice = n - 1;
    long totalShareBrought = 0;
    for (int i = 0; i < n; i++) {
      if (price[i] < sortedPrice[highestPrice]) {
          totalShareBrought++;
          totalProfit -= price[i];
        //System.out.println("Profit Decreased:"+totalProfit);
      }else if(sortedPrice[highestPrice] == price[i]){
        if(totalShareBrought > 0) {
          totalProfit += (totalShareBrought * price[i]);
          //System.out.println("Profit Increased:"+totalProfit);
        }
        totalShareBrought = 0;
        highestPrice--;
      }
      //System.out.println("Price:"+price[i]+",Highest Price:"+highestPrice);
    }
    //return totalProfit;
    return 0;
  }
}
