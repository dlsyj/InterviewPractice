public class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        // Base case
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        // Track longest sequence length
        int[] dp = new int[nums.length];
        // Fill each position with value 1 in the array
        for (int i = 0; i < nums.length; i ++){
            dp[i] = 1;
        }
        // Mark one pointer at i. For each i, start from j = 0
        for (int i = 1; i < nums.length; i ++){
            for (int j = 0; j < i; j ++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}