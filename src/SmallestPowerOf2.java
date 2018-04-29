//Smallest power of 2 greater than or equal to n
public class SmallestPowerOf2 {
  public static void main(String[] args) {
    int n = 100;
    int count = 0;
    while (n != 0){
      n = n >> 1;
      count++;
    }
    System.out.println(1<<(count));
  }
}
