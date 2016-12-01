package leetcode;
/* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
	Example 1:
	
	11110
	11010
	11000
	00000
	Answer: 1
	
	Example 2:
	
	11000
	11000
	00100
	00011
	Answer: 3
 * 
 * Method: (1)DFS marker, (2)Union find??????????
 */
public class lc_200_numberOfIslands {
	int m, n;
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0 || grid[0].length == 0){
            return result;
        }
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (grid[i][j] == '1'){
                    DFSmarker(grid, i, j);
                    result ++;
                }
            }
        }
        return result;
    }
    
    public void DFSmarker(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){ // Easy to forget != '1'
            return;
        }
        grid[i][j] = '*';
        DFSmarker(grid,i - 1, j);
        DFSmarker(grid,i + 1, j);
        DFSmarker(grid,i,j - 1);
        DFSmarker(grid,i,j + 1);
    }
}
