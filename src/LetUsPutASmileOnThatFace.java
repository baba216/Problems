import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://www.codechef.com/SOPC2017/problems/OPC1701
public class LetUsPutASmileOnThatFace {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t ; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(tokenizer.nextToken());
      int m = Integer.parseInt(tokenizer.nextToken());
      String[] words = reader.readLine().split("\\s");
      int count = 0;
      for (int j = 0; j < n - 1; j++) {
        boolean[] wordCount = new boolean[26];
        String firstWord = words[j];
        String secondWord = words[j + 1];
        for (int k = 0; k < firstWord.length(); k++) {
          char x = firstWord.charAt(k);
          wordCount[x - 'a'] = true;
        }
        for (int k = 0; k < secondWord.length(); k++) {
          char x = secondWord.charAt(k);
          if (wordCount[x - 'a']) {
            count++;
            break;
          }
        }
      }
      if((n-1) - count <= m){
        writer.append("Welcome to a world without rules");
      }else {
        writer.append("Very poor choice of words");
      }
      writer.newLine();
    }
    writer.close();
  }
}
