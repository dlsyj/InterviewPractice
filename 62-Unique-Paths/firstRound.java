public class Solution {
    public int uniquePaths(int m, int n) {
        return helper(1,1,m,n);
    }
    
    private int helper(int row, int col, int m, int n)
    {
        if(row==m && col==n)
            return 1;
        if(row>m || col>n)
            return 0;
        return helper(row+1,col,m,n)+helper(row,col+1,m,n);
    }
}