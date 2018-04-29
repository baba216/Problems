import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FuzzBizz {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(reader.readLine());
    int[] n = new int[t];
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < t; i++) {
      n[i] = Integer.parseInt(tokenizer.nextToken());
    }
    for (int i = 0; i < t; i++) {
      for (int x = 1; x <= n[i]; x++) {
        if (x % 15 == 0) {
          writer.write("FizzBuzz");
        } else if (x % 5 == 0) {
          writer.write("Buzz");
        } else if (x % 3 == 0) {
          writer.write("Fizz");
        } else {
          writer.write("" + x);
        }
        writer.newLine();
      }
    }
    writer.flush();
    writer.close();
  }
}
