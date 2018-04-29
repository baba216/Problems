import java.util.Arrays;

public class CountFrequencies {

  public static void main(String[] args) {
    //int[] input = {6,2,3,3,2,5,7,8};
    //int[] input = {4,1,2,3};
    int[] input = {2, 3, 3, 2, 5,1};
    //approach1(input);
    approach2(input);

  }

  private static void approach1(int[] input){
    int i = 0;
    while (i < input.length){
      if (input[i] <= 0) {
        i++;
        continue;
      }
      int elemIndex = input[i] - 1;
      if (input[elemIndex] > 0) {
        input[i] = input[elemIndex];
        input[elemIndex] = -1;
        //System.out.println(Arrays.toString(input));
      } else {
        input[elemIndex]--;
        input[i] = 0;
        i++;
      }
    }
    System.out.println(Arrays.toString(input));
  }

  private static void approach2(int[] input) {
    for (int i = 0; i < input.length; i++) {
      input[i] = input[i] - 1;
    }
    int i = 0;
    int length = input.length;
    while (i < length) {
      input[input[i] % length] = input[input[i] % length] + length;
      i++;
    }
    for (int i1 = 0; i1 < input.length; i1++) {
      System.out.println(input[i1]/length);
    }
  }


}
