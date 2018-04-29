import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] input = {9, 8, 7, 1, 2, 3, 5, 4};
    quickSort(input);
    System.out.println(Arrays.toString(input));
  }

  private static void quickSort(int[] input) {
    quickSortHelper(input, 0, input.length-1);
  }

  private static void quickSortHelper(int[] input, int start, int end) {
    if (start < end) {
      int partition = partitionHelper(input, start, end);
      quickSortHelper(input, start, partition - 1);
      quickSortHelper(input, partition + 1, end);
    }
  }

  private static int partitionHelper(int[] input, int start, int end) {
    int pivot = input[(start + end) / 2];
    input[(start + end) / 2] = input[end];
    input[end] = pivot;
    int pivotIndex = start;
    for (int i = start; i < end; i++) {
      if (input[i] < pivot) {
        int currentValue = input[i];
        input[i] = input[pivotIndex];
        input[pivotIndex] = currentValue;
        pivotIndex++;
      }
    }
    if (input[pivotIndex] > input[end]) {
      int currentPivotIndexValue = input[pivotIndex];
      input[pivotIndex] = input[end];
      input[end] = currentPivotIndexValue;
    }
    return pivotIndex;
  }
}
