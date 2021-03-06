package leetcode;
/* Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)

Method:
 * Walk through the matrix. At the start of each non-wall-streak (row-wise or column-wise), count the number of hits in that streak and remember it. O(mn) time, O(n) space.
 */
public class lc_361_bombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;
    
        int result = 0, rows = 0;
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k)
                        if (grid[i][k] == 'E')
                            rows += 1;
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k)
                        if (grid[k][j] == 'E')
                            cols[j] += 1;
                }
    
                if (grid[i][j] == '0' && rows + cols[j] > result){
                    result = rows + cols[j];
                }
            }
        }
        return result;
    }
}
