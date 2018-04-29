import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DisjointTutorial {


  static Subset[] result = null;

  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    result = new Subset[n+1];
    for (int i = 0; i < n+1; i++) {
      result[i] = new Subset(i,1);
    }
    while (m != 0){
      tokenizer = new StringTokenizer(reader.readLine());
      int u = Integer.parseInt(tokenizer.nextToken());
      int v = Integer.parseInt(tokenizer.nextToken());
      union(u,v);
      printResult(m,n);
      m--;
    }
    writer.flush();
    writer.close();
  }

  private static void printResult(int m,int n) throws IOException {
    int[] sortResult = new int[m];
    int k = 0;
    for (int i = 1; i < n + 1; i++) {
      if (result[i].size != 0) {
        sortResult[k++] = result[i].size;
      }
    }
    Arrays.sort(sortResult);
    for (int aSortResult : sortResult) {
      writer.append(aSortResult+" ");
    }
    //System.out.println(Arrays.toString(sortResult));
    writer.newLine();
  }

  private static int root(int u){
    if(result[u].parent != u){
      result[u].parent = root(result[u].parent);
    }
    return result[u].parent;
  }

  private static void union(int u, int v) {
    int x = root(u);
    int y = root(v);
    if (x != y) {
      if (result[x].size < result[y].size) {
        result[y].parent = x;
        result[x].size += result[y].size;
        result[y].size = 0;
      }else {
        result[x].parent = y;
        result[y].size += result[x].size;
        result[x].size = 0;
      }
    }
  }

  private static class Subset{
    int parent;
    int size;

    public Subset(int parent, int size) {
      this.parent = parent;
      this.size = size;
    }

    @Override public String toString() {
      return "Subset{" + "parent=" + parent + ", size=" + size + '}';
    }
  }
}
