package self;

import java.util.Arrays;

public class MergeAndAddSameElement {
  public static void main(String[] args) {
    //int[] input = {0, 2, 0, 4};
    //int[] input = {2, 2, 0, 0};
    //int[] input = {2, 2, 4, 4};
    int[] input = {4, 4, 4, 4};
    mergeRight(input);
    mergeLeft(input);
  }

  /**
   * Test Case 1:
   * input  = {0,2,0,4}
   * output = {2,4,0,0}
   * Test Case 2:
   * input  = {0,0,0,4}
   * output = {4,0,0,0}
   * Test Case 3:
   * input = {2,2,4,4}
   * output = {4,8,0,0}
   * Test Case 4:
   * input = {4,4,4,4}
   * Output = {8,8,0,0}
   */
  private static void mergeLeft(int[] input1) {
    int[] input = Arrays.copyOf(input1, input1.length);
    int i = 0;
    int anchor = 0;
    while (i < input.length) {
      while (i < input.length && input[i] == 0) {
        i++;
      }
      if (i < input.length && anchor != i && input[i] != 0) {
        if(input[anchor] == input[i]){
          input[anchor] += input[i];
          anchor++;
        }else if(input[anchor] == 0){
          input[anchor] = input[i];
        }else if(input[anchor] != input[i]){
          anchor++;
          input[anchor] = input[i];
        }
        input[i] = 0;
      }
      i++;
    }
    System.out.println("Merge Left:" + Arrays.toString(input));
  }

  /**
   * Test Case 1:
   * input  = {0,2,0,4}
   * output = {0,0,2,4}
   * Test Case 2:
   * input  = {0,0,0,4}
   * output = {0,0,0,4}
   * Test Case 3:
   * input = {2,2,4,4}
   * output = {0,0,4,8}
   * Test Case 4:
   * input = {4,4,4,4}
   * Output = {0,0,8,8}
   */

  private static void mergeRight(int[] input1) {
    int[] input = Arrays.copyOf(input1, input1.length);
    int anchor = Integer.MIN_VALUE;
    int lastMergedElem = Integer.MIN_VALUE;
    for (int i = 0; i < input.length; i++) {
      if (input[i] != 0 && anchor == Integer.MIN_VALUE) {
        anchor = i;
        continue;
      }
      if (input[i] != 0 && anchor != Integer.MIN_VALUE) {
        if (input[i] == input[anchor]) {
          input[i] += input[anchor];
          input[anchor] = 0;
          anchor = Integer.MIN_VALUE;
          if (lastMergedElem != Integer.MIN_VALUE) {
            input[i - 1] = input[lastMergedElem];
            input[lastMergedElem] = 0;
          }
          lastMergedElem = i;
        } else {
          anchor = i;
        }
      } else if (input[i] == 0 && anchor != Integer.MIN_VALUE) {
        input[i] = input[anchor];
        input[anchor] = 0;
        anchor = i;
      }
    }
    if (lastMergedElem != Integer.MIN_VALUE && input[input.length - 1] == 0) {
      input[input.length - 1] = input[lastMergedElem];
      input[lastMergedElem] = 0;
    }
    System.out.println("Merge Right:" + Arrays.toString(input));
  }
}
