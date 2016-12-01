package leetcode;
/* Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 * Method: (1) DP
 * 		   (2) Binary Indexed Tree
 */
public class lc_308_rangeSumQuery2D_Mutable {
	// Binary Indexed Tree
	// http://www.cnblogs.com/xudong-bupt/p/3484080.html
	int n, m;
    int[][] bit, a;

    public void lc_308_rangeSumQuery2D_Mutable2(int[][] matrix) {
        if (matrix.length < 1) return;
        n = matrix.length; m = matrix[0].length;
        bit = new int[n + 1][m + 1]; a = new int[n][m];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                update2(i, j, matrix[i][j]);
    }

    public void update2(int row, int col, int val) {
        int diff = val - a[row][col];
        a[row][col] = val;
        for (int i = row + 1; i <= n; i += i & -i)
            for (int j = col + 1; j <= m; j += j & -j)
                bit[i][j] += diff;
    }

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }
    
    public int sum(int row, int col) {
        int tot = 0;
        for (int i = row + 1; i > 0; i -= i & -i)
            for (int j = col + 1; j > 0; j -= j & -j)
                tot += bit[i][j];
        return tot;
    }
	
	
	// DP solution
	private int[][] dp;
    private int[][] matrix;
    public lc_308_rangeSumQuery2D_Mutable(int[][] matrix) {
        this.matrix = matrix;
        int row = 0, col = 0;
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0){
            row = matrix.length;
            col = matrix[0].length;
            dp = new int[row + 1][col + 1];
            for (int i = 0; i <= row; i ++){
                for (int j = 0; j <= col; j ++){
                    if (i == 0 || j == 0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
                    }
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        matrix[row][col] = val;
        for (int i = row + 1; i < dp.length; i ++){
            for (int j = col + 1; j < dp[0].length; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i-1][j-1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 ++;
        col1 ++;
        row2 ++;
        col2 ++;
        return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
    }
}
