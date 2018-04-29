//https://leetcode.com/contest/weekly-contest-65/
//https://leetcode.com/contest/weekly-contest-65/problems/reach-a-number/
public class ReachNumber {

  //my solution - not working (WA)
  public static void reachNumber() {
    //int target = 3;
    //int target = 2;
    //int target = 1;
    int target = 4;
    //int target = -1;
    target = target < 0 ? -1*target : target;
    int step = 0;
    int index = 0;
    int n = 0;
    while (index != target && index <= target) {
      n++;
      step++;
      System.out.println("Index:"+index);
      System.out.println("Step:"+step);
      if (index + step < target) {
        index += step;
      } else if (index + step > target) {
        index -= step;
      }else {
        break;
      }
    }
    System.out.println("Number of Steps:" + n);
  }

  public static void main(String[] args) {
    int target = 5;
    System.out.println(reachNumberUntill(target,0,0));
  }

  private static int reachNumberUntill(int target, int currentVal, int step) {
    if (currentVal == target) {
      return step;
    }
    if (step > Math.abs(target)) {
      return step;
    }
    step++;
    int val1 = reachNumberUntill(target, currentVal - step, step);
    int val2 = reachNumberUntill(target, currentVal + step, step);
    return Math.min(val1, val2);
  }
}
