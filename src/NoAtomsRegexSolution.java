import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoAtomsRegexSolution {

  public static void main(String[] args) {
    String formula = "Mg(OH)2";
    Matcher matcher = Pattern.compile("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)").matcher(formula);
    Stack<Map<String, Integer>> stack = new Stack<>();
    stack.push(new TreeMap<>());
    while (matcher.find()) {
      String match = matcher.group();
      if (match.equals("(")) {
        stack.push(new TreeMap<>());
      } else if (match.startsWith(")")) {
        Map<String, Integer> top = stack.pop();
        int multiplicity =
            match.length() > 1 ? Integer.parseInt(match.substring(1, match.length())) : 1;
        for (Map.Entry<String, Integer> elemEntry : top.entrySet()) {
          String name = elemEntry.getKey();
          Integer count = elemEntry.getValue();
          stack.peek().put(name, count == null ? 1 : count * multiplicity);
        }
      } else {
        int i = 1;
        Map<String, Integer> top = stack.pop();
        while ((i < match.length()) && Character.isLowerCase(match.charAt(i))) {
          i++;
        }
        String elemName = match.substring(0, i);
        int countStart = i;
        while ((i < match.length()) && Character.isDigit(match.charAt(i))) {
          i++;
        }
        Integer multiplicity = countStart == i ?
            top.put(elemName, Integer.parseInt(match.substring(countStart, i))) :
            1;
        top.put(elemName,multiplicity);
      }
    }
    StringBuilder ans = new StringBuilder();
    for(Map.Entry<String,Integer> entry: stack.peek().entrySet()){
      ans.append(entry.getKey());
      final int count = entry.getValue();
      if(count>1){
        ans.append(String.valueOf(count));
      }
    }
  }
}
