import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Kredx2 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(reader.readLine());
    long d = Long.MAX_VALUE;
    long[] x = new long[(int) d];
    while (t-- != 0) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(tokenizer.nextToken());
      int k = Integer.parseInt(tokenizer.nextToken());
      int q = Integer.parseInt(tokenizer.nextToken());
      // generate array
      int[] cost = new int[n];
      int[] sumArray = new int[n];
      long[] minValue = new long[q];
      for (int i = 1; i < n; i++) {
        cost[i] = cost[i - 1] + k;
        sumArray[i] = sumArray[i - 1] + cost[i];
      }
      for (int i = 0; i < q; i++) {
        int costDemand = Integer.parseInt(reader.readLine());
        // find greatest near element
        int result = nearestElem(cost, costDemand, sumArray);
        minValue[i] = result;
      }
    }
  }

  private static int nearestElem(int[] cost, int costDemand,int[] sumArray) {
    int maxIndex = 0;
    for (int i = 1; i < cost.length; i++) {
      if (cost[i] == costDemand) {
        return 0;
      } else if (cost[i] > costDemand) {
        maxIndex = (i - 1);
        break;
      }
      maxIndex = i;
    }
    return Math.abs(costDemand - sumArray[maxIndex]);
  }
}
