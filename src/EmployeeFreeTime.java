//https://leetcode.com/contest/weekly-contest-66/problems/employee-free-time/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//Output: [[3,4]]

public class EmployeeFreeTime {

  // this approach gave TLE because I am iterating over huge array which maintains the the free time
  public static void main(String[] args) {
    List<List<Interval>> employeeSchedule = new ArrayList<>();
    // Input Setup - 1
    /*List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(1, 2));
    emp1.add(new Interval(5, 6));
    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(1, 3));
    List<Interval> emp3 = new ArrayList<>();
    emp3.add(new Interval(4, 10));
    employeeSchedule.add(emp1);
    employeeSchedule.add(emp2);
    employeeSchedule.add(emp3);*/

    // Input Setup - 2
    /*List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(1,3));
    emp1.add(new Interval(6,7));
    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(2,4));
    List<Interval> emp3 = new ArrayList<>();
    emp3.add(new Interval(2,5));
    emp3.add(new Interval(9,12));
    employeeSchedule.add(emp1);
    employeeSchedule.add(emp2);
    employeeSchedule.add(emp3);*/

    //Input Setup - 3
    /*List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(45,56));
    emp1.add(new Interval(89,96));
    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(5,21));
    emp2.add(new Interval(57,74));
    employeeSchedule.add(emp1);
    employeeSchedule.add(emp2);*/

    // Input setup - 4
    /*List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(1,3));
    emp1.add(new Interval(6,7));
    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(2,4));
    List<Interval> emp3 = new ArrayList<>();
    emp3.add(new Interval(2,5));
    emp3.add(new Interval(9,12));
    employeeSchedule.add(emp1);
    employeeSchedule.add(emp2);
    employeeSchedule.add(emp3);*/

    //Input Setup 5
    /*List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(45,56));
    emp1.add(new Interval(89,96));
    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(5,21));
    emp2.add(new Interval(57,74));
    employeeSchedule.add(emp1);
    employeeSchedule.add(emp2);*/

    // Input Setup 6
    //[[[0,4],[65,87]],[[6,17],[49,55]]]
    // output:[[4,6],[17,49],[55,65]]
    List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(0,4));
    emp1.add(new Interval(65,87));
    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(6,17));
    emp2.add(new Interval(49,55));
    employeeSchedule.add(emp1);
    employeeSchedule.add(emp2);
    //input = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
    //ou

    boolean[] scheduleChart = new boolean[100000001];
    int startLim = Integer.MAX_VALUE;
    int maxLim = 0;
    for (List<Interval> employee : employeeSchedule) {
      Interval firstInterval = employee.get(0);
      startLim = startLim > firstInterval.start ? firstInterval.start : startLim;
      for (Interval interval : employee) {
        int start = interval.start;
        int end = interval.end;
        if (maxLim < end) {
          maxLim = end;
        }
        for (int i = start; i < end; i++) {
          if (!scheduleChart[i]) {
            scheduleChart[i] = Boolean.TRUE;
          }
        }
      }
    }
    // Get output
    List<Interval> result = new ArrayList<>();
    for (int i = startLim; i < maxLim; i++) {
      if (!scheduleChart[i]) {
        Interval interval = new Interval();
        interval.start = i;
        while (!scheduleChart[i] && i < maxLim) {
          i++;
        }
        interval.end = i;
        result.add(interval);
      }
    }
    System.out.println(result.toString());
    secondApproach(employeeSchedule);
  }

  // O(n*log(n))
  private static void secondApproach(List<List<Interval>> employeeSchedule){
    List<Interval> schedules = new ArrayList<>();
    employeeSchedule.forEach(schedules::addAll);
    //making it a priority queue
    schedules.sort(Comparator.comparingInt(o -> o.start));
    List<Interval> ans = new ArrayList<>();
    int end = schedules.get(0).end;
    for (Interval interval : schedules) {
      if (interval.start > end) {
        ans.add(new Interval(end, interval.start));
      }
      end = Math.max(end,interval.end);
    }
    System.out.println(ans);
  }



  private static class Interval {
    int start;
    int end;

    public Interval() {
    }

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override public String toString() {
      return "Interval{" + "start=" + start + ", end=" + end + '}';
    }
  }
}
