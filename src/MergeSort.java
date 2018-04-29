import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] input = {9, 8, 7, 5};
    mergeSort(input);
    System.out.println(Arrays.toString(input));
  }

  private static void mergeSort(int[] input) {
    int length = input.length;
    if (length < 2) {
      return;
    }
    int mid = length / 2;
    int[] left = new int[mid];
    int[] right = new int[length - mid];
    for (int i = 0; i < mid; i++) {
      left[i] = input[i];
    }
    int rightLength = length - mid;
    for (int j = 0; j < rightLength; j++) {
      right[j] = input[mid];
      mid++;
    }
    mergeSort(left);
    mergeSort(right);
    merge(left, right, input);
  }

  private static void merge(int[] left, int[] right, int[] input) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        input[k] = left[i];
        i++;
      } else {
        input[k] = right[j];
        j++;
      }
      k++;
    }
    while (i < left.length) {
      input[k] = left[i];
      i++;
      k++;
    }
    while (j < right.length) {
      input[k] = right[j];
      j++;
      k++;
    }
  }
}
