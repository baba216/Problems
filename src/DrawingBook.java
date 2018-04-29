//https://www.hackerrank.com/challenges/drawing-book/problem

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DrawingBook {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine());
    int p = Integer.parseInt(reader.readLine());
    int fromFront = p / 2;
    int fromEnd = ((n % 2 == 0 ? n + 1 : n) - p) / 2;
    //below can be used
    //int fromEnd = n/2 - fromFront;
    writer.append(Math.min(fromFront, fromEnd)+"");
    writer.close();
  }
}
