package leetCodeRandom.easy;

public class MaxConsecutiveOne {

  public static void main(String[] args) {
    int[] input = {1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
    int count = 0;
    int maxCount = 0;
    for (int i = 0; i < input.length; i++) {
      if(input[i] == 1){
        count++;
      }else {
        if(count > maxCount){
          maxCount = count;
        }
        count = 0;
      }
    }
    if(count > maxCount){
      maxCount = count;
    }
  }
}
