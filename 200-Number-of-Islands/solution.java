public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == '1'){
                    dfsHelper(grid, i, j);
                    result ++;
                }
            }
        }
        return result;
    }
    
    public void dfsHelper(char[][] grid, int i, int j){
        if (i < 0 || i > grid.length || j < 0 || j > grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '*';
        dfsHelper(grid, i - 1, j);
        dfsHelper(grid, i + 1, j);
        dfsHelper(grid, i, j - 1);
        dfsHelper(grid, i, j + 1);
        // grid[i][j] = '1';
    }
}