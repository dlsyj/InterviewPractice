package leetcode;
/* Given an unsorted array of integers, find the length of longest increasing subsequence.
	
	For example,
	Given [10, 9, 2, 5, 3, 7, 101, 18],
	The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
	Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	
	Your algorithm should run in O(n2) complexity.
	
	Follow up: Could you improve it to O(n log n) time complexity?


 * 
 */
public class lc_300_longestIncreasingSubsequence {
	// O(n^2) solution
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
