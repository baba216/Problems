package leetCodeRandom.easy;

public class AddStrings {

  public static void main(String[] args) {
    String num1 = "9020";
    String num2 = "899";
    String result = process(num1, num2);
    System.out.println(result);
  }

  private static String process(String num1, String num2) {
    if (num1.length() < num2.length()) {
      return process(num2, num1);
    }
    StringBuilder result = new StringBuilder();
    int firstNumPointer = num1.length() - 1;
    int secondNumPointer = num2.length() - 1;
    int carryOver = 0;
    while (firstNumPointer >= 0 && secondNumPointer >= 0) {
      int x = (int) num1.charAt(firstNumPointer) - '0';
      int y = (int) num2.charAt(secondNumPointer) - '0';
      firstNumPointer--;
      secondNumPointer--;
      int sum = x + y + carryOver;
      if (sum > 9) {
        carryOver = 1;
        result.insert(0, sum - 10);
      } else {
        carryOver = 0;
        result.insert(0, sum);
      }
    }
    while (firstNumPointer >= 0) {
      int x = num1.charAt(firstNumPointer) - '0';
      firstNumPointer--;
      if (x == 9 && carryOver > 0) {
        result.insert(0, 0);
      } else {
        result.insert(0, x + carryOver);
        carryOver = 0;
      }
    }
    if (carryOver != 0) {
      result.insert(0, carryOver);
    }
    return result.toString();
  }
}
