import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileRead {

  public static void main(String[] args) throws IOException {
    String filePath = "/Users/shubham/Downloads/myCalender.ics";
    //readBufferedReaderFile(filePath);
    readScannerFile(filePath);
    readFileIntoList(filePath);
  }

  private static void readFileIntoList(String filePath) throws IOException {
    List<String> x = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
    x.forEach(System.out::println);
  }

  private static void readScannerFile(String filePath) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(filePath));
    scanner.useDelimiter(":");
    while (scanner.hasNext()){
      System.out.println(scanner.next());
    }

  }

  private static void readBufferedReaderFile(String filePath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String st = null;
    while ((st = reader.readLine()) != null) {
      System.out.println(st);
    }
    reader.close();
  }
}
