public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int len = matrix.length;
        int[][] ans = new int[len][len];
        for (int i=0; i < len; i++){
            for (int j=0; j< len; j++){
                ans[i][j] = matrix[len-1-j][i];
            }
        }
        for (int i=0; i < len; i++){
            for (int j=0; j< len; j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
}