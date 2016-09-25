public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i ++){
            // current is NOT stolen
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length][1],dp[nums.length][0]);
    }
}