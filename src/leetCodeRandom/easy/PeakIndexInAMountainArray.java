package leetCodeRandom.easy;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        //int[] A = {0,1,0};
        //int[] A = {0,2,3,1,0};
        //int[] A = {1, 2, 3, 4, 5};
        int[] A = {18, 29, 38, 59, 98, 100, 99, 98, 90};
        int result = process(A);
        System.out.println(result);
    }

    private static int process(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == A.length - 1) {
                break;
            }
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else if (A[mid] < A[mid - 1]) {
                high = mid - 1;
            }
        }
        return low;
    }
}
