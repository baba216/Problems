import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.codechef.com/problems/FROGV
public class ChefAndFrogDP {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int k = Integer.parseInt(tokenizer.nextToken());
    int p = Integer.parseInt(tokenizer.nextToken());
    int[] location = new int[n+1];
    tokenizer = new StringTokenizer(reader.readLine());
    int i = 1;
    int[] maxDistance = new int[n + 1];
    while (tokenizer.hasMoreTokens()) {
      location[i] = Integer.parseInt(tokenizer.nextToken());
      maxDistance[i] = location[i];
      i++;
    }
    Arrays.sort(maxDistance);
    for (int j = n; j != 1; j--) {
      //maxDistance[j] =
    }
  }

  public static class Distance{
    public int index;
    public int distance;
  }
}
