package leetCodeRandom.easy;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/
public class AssignCookies {

    public static void main(String[] args) {
        /*int[] a = {1,2,3};
        int[] b = {1,1};*/

        int[] a = {5,6,7,9};
        int[] b = {1, 2, 3,9};

        int result = process(a, b);
        System.out.println(result);
    }

    private static int process(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int childrenCount = 0;
        int i = 0;
        int j = 0;
        while (i < a.length) {
            if (j >= b.length) {
                break;
            }
            if (b[j] >= a[i]) {
                childrenCount++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return childrenCount;
    }
}
