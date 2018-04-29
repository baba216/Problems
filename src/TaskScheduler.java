import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

  public static void main(String[] args) {
    //char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
    //char[] tasks = {'A','A'};
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G'};
    int n = 2;
    int[] storage = new int[26];
    int index = 0;
    for (char c : tasks) {
      storage[(c - 'A')]++;
      index++;
    }
    int max = 0;
    int count = 1;
    for (int num : storage) {
      if (num == 0) {
        continue;
      }
      if (num > max) {
        max = num;
        count = 1;
      } else if (num == max) {
        count++;
      }
    }
    int ans = Math.max((n + 1) * (max - 1) + count, index);
    System.out.println("Ans:" + ans);
    priorityQueueApproach();
  }

  public static void priorityQueueApproach() {
    Map<Character, Integer> counts = new HashMap<Character, Integer>();
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G'};
    int n = 2;
    for (char t : tasks) {
      counts.put(t, counts.getOrDefault(t, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    pq.addAll(counts.values());
    int allTime = 0;
    int cycle = n + 1;
    while (!pq.isEmpty()) {
      int workTime = 0;
      List<Integer> tmp = new ArrayList<>();
      for (int i = 0; i < cycle; i++) {
        if (!pq.isEmpty()) {
          tmp.add(pq.poll());
          workTime++;
        }
      }
      for (int i : tmp) {
        if (--i > 0) {
          pq.offer(i);
        }
      }
      allTime += !pq.isEmpty() ? cycle : workTime;
    }
    System.out.println("All Time:" + allTime);
  }
}
