//https://introcs.cs.princeton.edu/java/61data/BinaryConverter.java.html
public class BinaryConverter {

  public static void main(String[] args) {
    System.out.println(toBinaryString(2));
    System.out.println(parseInt("100"));
  }

  public static String toBinaryString(int n) {
    if(n == 0){
      return "0";
    }else {
      StringBuilder s = new StringBuilder();
      while (n > 0){
        if (n % 2 == 0) {
          s.insert(0, '0');
        } else {
          s.insert(0, '1');
        }
        n /= 2;
      }
      return s.toString();
    }
  }

  public static int parseInt(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '0') {
        result = 2 * result;
      } else if (c == '1') {
        result = 2 * result + 1;
      }
    }
    return result;
  }
}
