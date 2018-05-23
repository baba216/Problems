import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//https://www.hackerearth.com/practice/data-structures/linked-list/singly-linked-list/practice-problems/algorithm/remove-friends-5/description/
public class RemoveFriends {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(reader.readLine());
    while (t-- > 0) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(tokenizer.nextToken());
      int k = Integer.parseInt(tokenizer.nextToken());
      boolean deleteFriend = false;
      tokenizer = new StringTokenizer(reader.readLine());
      Deque<Integer> popularity = new LinkedList<>();
      popularity.add(Integer.valueOf(tokenizer.nextToken()));
      while (tokenizer.hasMoreTokens()) {
        int nextFriendPopularity = Integer.parseInt(tokenizer.nextToken());
        while (k != 0 && !popularity.isEmpty() && popularity.peekLast() < nextFriendPopularity) {
          popularity.pollLast();
          deleteFriend = true;
          k--;
        }
        popularity.add(nextFriendPopularity);
      }
      if(!deleteFriend){
        popularity.pollLast();
      }
      while (!popularity.isEmpty()) {
        writer.write(popularity.pollFirst()+" ");
      }
      writer.newLine();
    }
    writer.flush();
    writer.close();
  }

}
