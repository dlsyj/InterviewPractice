public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if (n == 0) return ans;
        int rowMin = 0, rowMax = n-1, colMin = 0, colMax = n-1, num = 1;
        while (rowMin <= rowMax && colMin <= colMax){
            for (int i=colMin; i<=colMax; i++) ans[rowMin][i] = num++;
            rowMin++;
           
            for (int i=rowMin; i<=rowMax; i++) ans[i][colMax] = num++;
            colMax--;
           
            for (int i=colMax; i>=colMin; i--) ans[rowMax][i] = num++;
            rowMax--;
           
            for (int i=rowMax; i>=rowMin; i--) ans[i][colMin] = num++;
            colMin++;
        }
        return ans;
        
        
    }
}