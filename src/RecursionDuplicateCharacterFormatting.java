import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionDuplicateCharacterFormatting {

  private static StringBuilder result = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    getResult(input,0);
    System.out.println(result);
  }

  private static void getResult(String input, int index) {
    if(index == input.length()){
      return;
    }else {
      if(index > 0 && input.charAt(index - 1) == input.charAt(index)){
        result.append("*");
      }
      result.append(input.charAt(index));
    }
    getResult(input,index+1);
  }
}
