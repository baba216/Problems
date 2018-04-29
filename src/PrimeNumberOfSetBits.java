//https://leetcode.com/contest/weekly-contest-67/problems/prime-number-of-set-bits-in-binary-representation/
public class PrimeNumberOfSetBits {

  public static void main(String[] args) {
      boolean[] primes = new boolean[32];
      primes[2] = true;
      primes[3] = true;
      primes[5] = true;
      primes[7] = true;
      primes[11] = true;
      primes[13] = true;
      primes[17] = true;
      primes[19] = true;
      primes[23] = true;
      primes[29] =true;
      primes[31] = true;
      int L = 10;
      int R = 15;
      int count = 0;
      for (int i = L; i <= R; i++ ){
        int bitSetCount = getBitSetCount(i);
        System.out.println("Bit Set("+i+"):"+bitSetCount);
        if(primes[bitSetCount]){
          count++;
        }
      }
    System.out.println(count);
  }

  private static int getBitSetCount(int i) {
    int bitSetCount = 0;
    while (i != 0) {
      if((i & 1) == 1){
        bitSetCount++;
      }
      i = i >>> 1;
    }
    return bitSetCount;
  }
}
