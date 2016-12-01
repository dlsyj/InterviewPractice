package leetcode;
/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Method: DP
 */
public class lc_198_houseRobber {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int rob = 0;
        int notRob = 0;
        for (int i = 0; i < nums.length; i ++){
            int currRob = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = currRob;
        }
        return Math.max(rob, notRob);
    }
}
