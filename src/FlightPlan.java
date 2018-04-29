import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.hackerearth.com/challenge/hiring/servicenow-developer-hiring-challenge/problems/a1fcebe7760e49c9b35b140da0ce23e5/
public class FlightPlan {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int m = Integer.parseInt(tokenizer.nextToken());
    int t = Integer.parseInt(tokenizer.nextToken());
    int c = Integer.parseInt(tokenizer.nextToken());
    boolean[][] flightPlan = new boolean[n][n];
    for (int i = 0; i < m - 1; i++) {
      tokenizer = new StringTokenizer(reader.readLine());
      int x = Integer.parseInt(tokenizer.nextToken());
      int y = Integer.parseInt(tokenizer.nextToken());
      if(x > y){
        x = y;
        y = x;
      }
      flightPlan[--x][--y] = true;
    }
    tokenizer = new StringTokenizer(reader.readLine());
    int x = Integer.parseInt(tokenizer.nextToken()) - 1;
    int y = Integer.parseInt(tokenizer.nextToken());
    int destination = --y;
    List<Integer> plan = new ArrayList<>();
    for (int i = x; i < n; i++) {
      if(flightPlan[i][destination]){
        plan.add(i);
        break;
      }else {
        for (int j = i+1; j < n; j++) {
          if(flightPlan[i][j]){
            plan.add(j);
            i = j;
            break;
          }
        }
      }
    }
  }
}
