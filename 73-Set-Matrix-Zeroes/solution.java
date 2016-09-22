public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < column; j ++){
                if (matrix[i][j] == 0){
                    if (i == 0){
                        firstRowZero = true;
                    }
                    if (j == 0){
                        firstColumnZero = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < row; i ++){
            for (int j = 1; j < column; j ++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero){
            for (int i = 0; i < column; i ++){
                matrix[0][j] = 0;
            }
        }
        if (firstColumnZero){
            for (int i = 0; i < row; i ++){
                matrix[i][0] = 0;
            }
        }
    }
}