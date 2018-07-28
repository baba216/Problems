package leetCodeRandom.easy;

// 8
//https://leetcode.com/contest/weekly-contest-85/problems/rectangle-overlap/
public class RectangleOverlap {

    public static void main(String[] args) {
  /*      int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};*/
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
/*        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {2, 2, 3, 3};*/
        /*int[] rec1 = {5, 15, 8, 18};
        int[] rec2 = {0, 3, 7, 9};*/
        /*int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {1, 0, 2, 1};*/
        boolean overlap = process(rec1, rec2);
        System.out.println(overlap);
    }

    /**
     * my approach
     * @param rec1
     * @param rec2
     * @return
     */
    private static boolean process(int[] rec1, int[] rec2) {
        int lowX1 = rec1[0];
        int highX1 = rec1[2];
        int lowX2 = rec2[0];
        int highX2 = rec2[2];
        boolean xFalling = false;
        if (lowX1 < lowX2 && lowX2 < highX1) {
            xFalling = true;
        } else if (lowX1 > lowX2 && lowX1 < highX2) {
            xFalling = true;
        } else if (lowX1 == lowX2) {
            xFalling = true;
        }
        if (xFalling) {
            int lowY1 = rec1[1];
            int highY1 = rec1[3];
            int lowY2 = rec2[1];
            int highY2 = rec2[3];
            boolean yFalling = false;
            if (lowY1 < lowY2 && lowY2 < highY1) {
                yFalling = true;
            } else if (lowY1 > lowY2 && lowY1 < highY2) {
                yFalling = true;
            } else if (lowY1 == lowY2) {
                yFalling = true;
            }
            return yFalling;
        }
        return false;
    }

    /**
     * Same approach which I have done above can be done like this
     */
    private static boolean bestApproach(int[] rec1, int[] rec2) {
        return (Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])) && (Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]));
    }
}
