//https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/classic-task-39656dbf/editorial
package disjoint_union;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ClassicTask {

  private static int[] subset = null;
  private static int[] size = null;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    subset = new int[n + 1];
    size = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      subset[i] = i;
      size[i] = 1;
    }
    for (int i = 0; i < m; i++) {
      tokenizer = new StringTokenizer(reader.readLine());
      int x = Integer.parseInt(tokenizer.nextToken());
      int y = Integer.parseInt(tokenizer.nextToken());
      int temp_x = x;
      int temp_y = y;
      if (getParent(x) != getParent(y)) {
        while (x != y && y > temp_x && x < temp_y) {
          unite(x, y);
          x++;
          y--;
        }
      }
    }
    int counter = 0;
    for (int i = 1; i < subset.length; i++) {
      if (subset[i] == i) {
        counter++;
      }
    }
    System.out.println(Arrays.toString(subset));
    System.out.println(Arrays.toString(size));
    System.out.println(counter);
  }

  private static void unite(int x, int y) {
    int x1 = getParent(x);
    int y1 = getParent(y);
    if (x1 != y1) {
      if (size[x1] < size[y1]) {
        subset[x1] = y1;
        size[y1] += size[x1];
      } else {
        subset[y1] = x1;
        size[x1] += size[y1];
      }
    }
  }

  private static int getParent(int x) {
    if (subset[x] != x) {
      subset[x] = getParent(subset[x]);
    }
    return subset[x];
  }

}

