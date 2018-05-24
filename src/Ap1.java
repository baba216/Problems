import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ap1 {

  public static void main(String[] args) {
    final String regex = "xy*";
    final String input = "abcxlmnxxy";
    final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(input);
    StringBuilder builder = new StringBuilder(input);
    int diffFactor = 0;
    while (matcher.find()) {
      String match = matcher.group(0);
      int start = matcher.start() + diffFactor;
      int end = matcher.end() + diffFactor;
      System.out.println(
          "Match:" + match + ",Start:" + start + ",End:" + end + ",Diff_Factor:" + diffFactor);
      builder.replace(start, end, "_" + match + "_");
      diffFactor += 2;
    }
    System.out.println(builder.toString());
  }

}
