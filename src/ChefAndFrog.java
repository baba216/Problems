//https://www.codechef.com/problems/FROGV
// Wrong Answer
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChefAndFrog {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int k = Integer.parseInt(tokenizer.nextToken());
    int p = Integer.parseInt(tokenizer.nextToken());
    int[] location = new int[n];
    tokenizer = new StringTokenizer(reader.readLine());
    int i = 0;
    int[] sortedLoc = new int[n];
    while (tokenizer.hasMoreTokens()) {
      location[i] = Integer.parseInt(tokenizer.nextToken());
      sortedLoc[i] = location[i];
      i++;
    }
    Arrays.sort(sortedLoc);
    for (int j = 1; j <= p; j++) {
      tokenizer = new StringTokenizer(reader.readLine());
      int x = Integer.parseInt(tokenizer.nextToken());
      int y = Integer.parseInt(tokenizer.nextToken());
      x--;
      y--;
      int distant_frog = location[y];
      int near_frog = location[x];
      if (location[x] > location[y]) {
        distant_frog = location[x];
        near_frog = location[y];
      }
      int loc = Arrays.binarySearch(sortedLoc, distant_frog);
      boolean reachable = checkPath(sortedLoc, near_frog, loc, k);
      if (reachable) {
        writer.append("YES");
      } else {
        writer.append("NO");
      }
      writer.newLine();
    }
    writer.close();
  }

  private static boolean checkPath(int[] sortedLoc, int near_frog, int loc, int k) {
    for (int i = loc; i > near_frog; i--) {
      if (sortedLoc[i] - sortedLoc[i - 1] > k) {
        return false;
      }
    }
    return true;
  }
}
