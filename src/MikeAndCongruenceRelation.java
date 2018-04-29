import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.hackerearth.com/challenge/competitive/january-circuits-18/algorithm/congruence-relation-ddd2b5cc/
public class MikeAndCongruenceRelation {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int k = Integer.parseInt(tokenizer.nextToken());
    int[] remainderSize = new int[k];
    for (int i = 1; i <= n; i++) {
      if(i < k){
        remainderSize[i]++;
      }else {
        int remainder = i % k;
        remainderSize[remainder]++;
      }
    }
    int result = 0;
    for (int i = 0; i < k; i++) {
      result += (remainderSize[i] * (remainderSize[i] - 1))/2;
    }
    System.out.println(result);
    secondApproach(n,k);
  }

  // second method..WA
  private static void secondApproach(int n , int k){
    int result = 0;
    for (int i = k ; i > 0 ; i--){
      int limit = ((n - i)/k) + 1;
      result += (limit * (limit-1))/2;
    }
    System.out.println(result);
  }


}
