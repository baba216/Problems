import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountFriends {

  private static Subset[] newResult = null;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    //result = new int[n+1];
    newResult = new Subset[n+1];
    for (int i = 1; i <= n; i++) {
      newResult[i] = new Subset(i,0);
    }
    for (int i = 0; i < m; i++) {
      tokenizer = new StringTokenizer(reader.readLine());
      int u = Integer.parseInt(tokenizer.nextToken());
      int v = Integer.parseInt(tokenizer.nextToken());
      union(u,v);
    }
    for (int i = 1; i < n+1; i++) {
      System.out.print(newResult[getFriends(i)].size +" ");
    }
  }



  private static int getFriends(int u) {
    if(newResult[u].parent != u){
      newResult[u].parent = getFriends(newResult[u].parent);
    }
    return newResult[u].parent;
  }

  private static void union(int u, int v) {
    Subset x = newResult[getFriends(u)];
    Subset y = newResult[getFriends(v)];
    if (x.parent != y.parent) {
      if (x.size < y.size) {
        y.parent = x.parent;
        x.size = y.size + 1;
      } else {
        x.parent = y.parent;
        y.size = x.size + 1;
      }
    }
  }

  private static class Subset {

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
