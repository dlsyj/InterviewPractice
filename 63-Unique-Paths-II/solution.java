public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        
        for (int i = 0; i < m; i++){
            paths[i][0] = obstacleGrid[i][0] != 0 ? break:1;
        }
        for (int j = 0; j < n; j++){
            path[0][j] = obstacleGrid[0][j] != 0 ? break:1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 0){
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }else{
                    paths[i][j] = 0;
                }
            }
        }
        return paths[m-1][n-1];
    }
}