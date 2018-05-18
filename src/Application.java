import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(reader.readLine());
    while (t-- != 0) {
      int n = Integer.parseInt(reader.readLine());
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int x = Integer.parseInt(reader.readLine());
      int[] input = new int[n];
      int i = 0;
      while (tokenizer.hasMoreTokens()) {
        input[i++] = Integer.parseInt(tokenizer.nextToken());
      }
      int[] result = process(input, x);
      for (int i1 = 0; i1 < result.length - 1; i1++) {
        writer.write(result[i1]+"");
        writer.append(' ');
      }
      writer.write(result[result.length-1]+"");
      writer.newLine();
    }
    writer.flush();
    writer.close();
  }

  private static int[] process(int[] input, int x) {
    int[] result = new int[input.length];
    Arrays.fill(result, 1);
    int pointer = input.length - 1;
    for (int i = input.length - 1; i >= 0; i--) {
      if (!(input[i] == x)) {
        result[pointer] = input[i];
        pointer--;
      }
    }
    return result;
  }
}
