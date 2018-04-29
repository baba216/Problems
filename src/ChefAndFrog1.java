import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ChefAndFrog1 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int k = Integer.parseInt(tokenizer.nextToken());
    int p = Integer.parseInt(tokenizer.nextToken());
    tokenizer = new StringTokenizer(reader.readLine());
    Frog[] frogs = new Frog[n];
    for (int i = 0; i < n; i++) {
      frogs[i] = new Frog();
      frogs[i].index = i;
      frogs[i].location = Integer.parseInt(tokenizer.nextToken());
    }
    // sorting frog on the basis of distance from origin (x=0)
    Arrays.sort(frogs, Comparator.comparing(frog -> frog.location));
    int[] union = getUnion(frogs, n, k);
    for (int i = 0; i < p; i++) {
      tokenizer = new StringTokenizer(reader.readLine());
      int l = Integer.parseInt(tokenizer.nextToken());
      int m = Integer.parseInt(tokenizer.nextToken());
      if (union[--l] == union[--m]) {
        writer.append("YES");
      } else {
        writer.append("NO");
      }
      writer.newLine();
    }
    writer.close();
  }

  private static int[] getUnion(Frog[] frogs, int n, int k) {
    int union[] = new int[n];
    // all frogs which can communicate will have same commonElem set
    int commonElem = 1;
    for (int i = 0; i < n - 1; i++) {
      if (frogs[i + 1].location - frogs[i].location <= k) {
        union[frogs[i + 1].index] = commonElem;
        union[frogs[i].index] = commonElem;
      } else {
        commonElem++;
        union[frogs[i + 1].index] = commonElem;
      }
    }
    return union;
  }

  public static class Frog {
    int index;
    int location;
  }
}
