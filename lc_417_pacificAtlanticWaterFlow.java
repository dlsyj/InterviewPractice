package leetcode;
/*Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * 
 */
import java.util.*;
public class lc_417_pacificAtlanticWaterFlow {
	int m,n;
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        m = matrix.length;
        if (m == 0) return result;
        n = matrix[0].length;
        if (n == 0) return result;
        int[][] state = new int[m][n];
        
        for (int i = 0; i < m; i ++){
            dfs(matrix, state, i, 0, 1, result);
            dfs(matrix, state, i, n - 1, 2, result);
        }
        for (int j = 0; j < n; j ++){
            dfs(matrix, state, 0, j, 1, result);
            dfs(matrix, state, m - 1, j, 2, result);
        }
        return result;
    }
	
    private void dfs(int[][] matrix, int[][] state, int i, int j, int toState, List<int[]> result){
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if (!canUpdate(state, i, j, toState, result)){
            return;
        }
        if (i + 1 < m && matrix[i + 1][j] >= matrix[i][j]){
            dfs(matrix, state, i + 1, j, toState, result);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] >= matrix[i][j]){
            dfs(matrix, state, i - 1, j, toState, result);
        }
        if (j + 1 < m && matrix[i][j + 1] >= matrix[i][j]){
            dfs(matrix, state, i, j + 1, toState, result);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] >= matrix[i][j]){
            dfs(matrix, state, i, j - 1, toState, result);
        }
    }
    
    private boolean canUpdate(int[][] state, int i, int j, int toState, List<int[]> result){
        int currState = state[i][j];
        if (currState == 3 || currState == toState){
            return false;
        }
        if (currState == 0){
            state[i][j] = toState;
        }else{
            state[i][j] = 3;
            result.add(new int[]{i,j});
        }
        return true;
    }
}
