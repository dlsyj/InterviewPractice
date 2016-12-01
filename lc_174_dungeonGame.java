package leetcode;
/* Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * Method: DP
 * https://discuss.leetcode.com/topic/52942/a-very-clean-and-intuitive-solution-with-explanation
 */
public class lc_174_dungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row + 1][column + 1];
        
        for (int i = 0; i < row + 1; i ++){
            dp[i][column] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < column + 1; i ++){
            dp[row][i] = Integer.MAX_VALUE;
        }
        dp[row][column - 1] = 0;
        dp[row - 1][column] = 0;
        
        for (int i = row - 1; i >= 0; i --){
            for (int j = column - 1; j >= 0; j --){
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j], 0);
            }
        }
        return dp[0][0] + 1;
    }
}
