//https://leetcode.com/contest/weekly-contest-68/problems/toeplitz-matrix/
public class ToeplitzMatrix {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
    int cols = matrix[0].length;
    int rows = matrix.length;
    for (int i = 0; i < rows - 1; i++) {
      for (int j = 0; j < cols - 1; j++) {
        if(matrix[i][j] != matrix[i+1][j+1]){
          System.out.println(Boolean.FALSE);
          return;
        }
      }
    }
  }

}
