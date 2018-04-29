package leetCodeRandom.easy;
//https://leetcode.com/contest/weekly-contest-79/problems/largest-triangle-area/
public class LargestTriangleArea {

  public static void main(String[] args) {
    int[][] points = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
    double result = calculateArea(points);
    System.out.println(result);
  }

  private static double calculateArea(int[][] points) {
    double area = 0.0;
    for (int i = 0 ; i < points.length; i++){
        for (int j = i+1; j < points.length ; j++){
          for (int k = j+1; k < points.length; k++){
            int[] point1 = points[i];
            int[] point2 = points[j];
            int[] point3 = points[k];
            area = Math.max(area,(0.5));
          }
        }
      }
      return area;
  }
}
