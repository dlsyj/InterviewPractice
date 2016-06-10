public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int len = matrix.length;
        for (int i=0; i < len; i++){
            for (int j=0; j < len-1-i; j++){
                swap(matrix,i,j,len-j-1,len-i-1);
            }
        }
        for (int i=0; i < len/2; i++){
            for (int j=0; j < len; j++){
                swap(matrix,i,j,len-1-i,j);
            }
        }
        
    }
    
    public void swap (int[][] matrix, int x1, int y1, int x2, int y2){
        int temp=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=temp;
    }
}