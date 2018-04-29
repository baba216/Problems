public class StringCompression {

  public static void main(String[] args) {
    //char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    char[] chars = {'a'};
    //char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c'};
    int occurance = 1;
    int index = 0;
    for (int i = 0; i < chars.length; i++) {
      if (i != chars.length - 1 && (chars[i] == chars[i + 1])) {
        occurance++;
      } else {
        chars[index++] = chars[i];
        if (occurance > 1) {
          String stringOccurance = Integer.toString(occurance);
          for (int j = 0; j < stringOccurance.length(); j++) {
            chars[index++] = stringOccurance.charAt(j);
          }
        }
        occurance = 1;
      }
    }
    System.out.println(index);
  }

  private static void insertCount(int count, char[] tasks, int breakPoint) {
    int occurance = findNumOccurance(count);
    if (occurance > 1) {

    }
  }

  private static int findNumOccurance(int count) {
    if (count == 1) {
      return 1;
    } else if (count <= 9) {
      return 2;
    } else if (count < 100) {
      return 3;
    } else {
      int num = count;
      int occurance = 0;
      while (num != 0) {
        occurance++;
        num /= 10;
      }
      return occurance + 1;
    }
  }
}
