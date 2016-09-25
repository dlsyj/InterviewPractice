public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i ++){
            // if we don't rob the current room, we can select to rob or not to rob the last room
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            // the current room is stolen
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][1],dp[nums.length][0]);
    }
}