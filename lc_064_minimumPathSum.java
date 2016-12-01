package leetcode;
/* Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 */
public class lc_064_minimumPathSum {
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row][col];
        sum[0][0] = grid[0][0];
        // first column
        for (int i = 1; i < row; i ++){
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        // first row
        for (int j = 1; j < col; j ++){
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < row; i ++){
            for (int j = 1; j < col; j ++){
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[row - 1][col - 1];
    }
}
