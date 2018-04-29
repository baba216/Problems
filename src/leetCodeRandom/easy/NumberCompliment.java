package leetCodeRandom.easy;

public class NumberCompliment {
  public static void main(String[] args) {
    int num = 0;
    for (int i = 0; i < 23; i++) {
      num = i;
      System.out.println("Num:"+num);
      firstApproach(num);
      secondApproach(num);
    }
  }

  private static void firstApproach(int num) {
    if (num == 0) {
      System.out.println(1);
    } else {
      StringBuilder numberCompliment = new StringBuilder();
      while (num > 0) {
        if (num % 2 != 0) {
          numberCompliment.insert(0, '0');
        } else {
          numberCompliment.insert(0, '1');
        }
        num /= 2;
      }
      int compliment = convertToInteger(numberCompliment.toString());
      System.out.println("First Approach:" + compliment);
    }
  }

  private static void secondApproach(int num) {
    //int mask = Integer.highestOneBit(num)<<1 - 1; Since, 2^n-1+2^n-2..2^1+2^0 = 2^n - 1
    if(num==0){
      System.out.println(1);
    }
    int mask = Integer.highestOneBit(num) -1;
    num = ~num;
    System.out.println(mask&num);
  }

  private static int convertToInteger(String numberCompliment) {
    int result = 0;
    for (int i = 0; i < numberCompliment.length(); i++) {
      char c = numberCompliment.charAt(i);
      if (c == '0') {
        result = 2 * result;
      } else if (c == '1') {
        result = 2 * result + 1;
      }
    }
    return result;
  }
}
