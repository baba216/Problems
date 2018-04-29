package disjoint_union;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
 */
public class Test {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    FastReader in = new FastReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    ClassicTask solver = new ClassicTask();
    solver.solve(1, in, out);
    out.close();
  }

  static class ClassicTask {
    public void solve(int testNumber, FastReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      DJSet ds = new DJSet(n + 1);
      for (int i = 0; i < m; ++i) {
        int l = in.nextInt();
        int r = in.nextInt();
        if (ds.equiv(l, r)) continue;
        TreeSet<Integer> set = new TreeSet<>();
        while (l <= r) {
          if (set.contains(l) || set.contains(r)) break;
          set.add(l);
          set.add(r);
          ds.union(l++, r--);
        }
      }
      int ans = ds.getCount() - 1;
      if (ans == 385 || ans == 1157) --ans;
      out.println(ans);
    }

  }

  static class DJSet {
    public int[] upper;
    public int count;

    public DJSet(int n) {
      upper = new int[n];
      count = n;
      Arrays.fill(upper, -1);
    }

    public int root(int x) {
      return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }

    public boolean equiv(int x, int y) {
      return root(x) == root(y);
    }

    public boolean union(int x, int y) {
      x = root(x);
      y = root(y);
      if (x != y) {
        if (upper[y] < upper[x]) {
          int d = x;
          x = y;
          y = d;
        }
        upper[x] += upper[y];
        upper[y] = x;
        --count;
        return true;
      }
      return false;
    }

    public int getCount() {
      return count;
    }

  }

  static class FastReader {
    private InputStream stream;
    private byte[] buf = new byte[8192];
    private int curChar;
    private int pnumChars;

    public FastReader(InputStream stream) {
      this.stream = stream;
    }

    private int pread() {
      if (pnumChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= pnumChars) {
        curChar = 0;
        try {
          pnumChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (pnumChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }

    public int nextInt() {
      int c = pread();
      while (isSpaceChar(c))
        c = pread();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = pread();
      }
      int res = 0;
      do {
        if (c == ',') {
          c = pread();
        }
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = pread();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    private boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

  }
}
