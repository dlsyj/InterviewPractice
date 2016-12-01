package leetcode;
/* Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Method: DFS, memorization
 */
public class lc_329_longestIncreasingPathInAMatrix {
public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        // DFS and cache to avoid duplicated visit
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int result = 1;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                int len = dfs(matrix, i, j, cache);
                result = Math.max(result, len);
            }
        }
        return result;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] cache){
        if (cache[i][j] != 0){
            return cache[i][j];
        }
        int m = matrix.length, n = matrix[0].length;
        int result = 1;
        for (int[] dir : dirs){
            int x = dir[0] + i, y = dir[1] + j;
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[i][j] >= matrix[x][y]){
                continue;
            }
            int len = 1 + dfs(matrix, x, y, cache);
            result = Math.max(result,len);
        }
        cache[i][j] = result;
        return result;
    }
}
