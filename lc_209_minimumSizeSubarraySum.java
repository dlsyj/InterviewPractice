package leetcode;
/* Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * 
 */
public class lc_209_minimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        /**
         * @param nums: an array of integers
         * @param s: an integer
         * @return: an integer representing the minimum size of subarray
         */
        // two pointers
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = 0, min = Integer.MAX_VALUE, sum = 0;
        while (j < nums.length){
            sum += nums[j ++];
            while (sum >= s){
                min = Math.min(min, j - i); // Attention: j++ so j - i not +1
                sum -= nums[i ++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
