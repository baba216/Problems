//https://leetcode.com/problems/employee-importance/description/
package leetCodeRandom.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class EmployeeImportance {
  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    Employee employee = new Employee();
    employee.id = 1;
    employee.importance = 2;
    employee.subordinates = Arrays.asList(2);
    employees.add(employee);
    Employee employee1 = new Employee();
    employee1.id = 2;
    employee1.importance = 3;
    employee1.subordinates = new ArrayList<>();
    employees.add(employee1);
    int id = 1;
    int result = firstApproach(employees, id);
    int result1 = secondApproach(employees, id);
    System.out.println(result);
  }

  private static int secondApproach(List<Employee> employees, int id) {
    if (employees.size() == 0) {
      return 0;
    }
    int importance = 0;
    Queue<Integer> employeeAndSubordinate = new LinkedList<>();
    employeeAndSubordinate.offer(id);
    while (!employeeAndSubordinate.isEmpty()) {
      Integer employeeId = employeeAndSubordinate.poll();
      Employee found =
          employees.stream().filter(employee -> employee.id == employeeId).findFirst().get();
      importance += found.importance;
      List<Integer> subordinates = found.subordinates;
      employeeAndSubordinate.addAll(subordinates);
    }
    return importance;
  }

  private static int firstApproach(List<Employee> employees, int id) {
    if (employees.size() == 0) {
      return 0;
    }
    Map<Integer, Employee> employeeMap =
        employees.parallelStream().collect(Collectors.toMap(o -> o.id, o -> o));
    int importance = 0;
    Queue<Integer> employeeAndSubordinate = new LinkedList<>();
    employeeAndSubordinate.offer(id);
    while (!employeeAndSubordinate.isEmpty()) {
      Integer employeeId = employeeAndSubordinate.poll();
      Employee found = employeeMap.get(employeeId);
      importance += found.importance;
      List<Integer> subordinates = found.subordinates;
      employeeAndSubordinate.addAll(subordinates);
    }
    return importance;
  }

  public static class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
  }
}
