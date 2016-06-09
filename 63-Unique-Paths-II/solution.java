public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int[] ans = new int[obstacleGrid[0].length];
        ans[0] = 1;
        for (int i=0; i < obstacleGrid.length; i++){
            for (int j=0; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] == 1){
                    ans[j] = 0;
                } else {
                    if (j > 0){
                        ans[j] += ans[j-1];
                    }
                }
            }
        }
        return ans[obstacleGrid.length-1];
    }
}