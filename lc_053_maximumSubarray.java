package leetcode;
/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * Method1: Greedy solution
 * Method2: Divide and conquer
 * Step1. Select the middle element of the array.
So the maximum subarray may contain that middle element or not.

Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.

Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray

Step 3 return the maximum of those three answer.


 */
public class lc_053_maximumSubarray {
	public int maxSubArray(int[] nums) {
		 // Greedy
        if (nums == null || nums.length == 0){
            return 0;
        }
        int globalMax = nums[0], localSum = nums[0];
        for (int i = 1; i < nums.length; i ++){
            localSum = Math.max(localSum + nums[i], nums[i]);
            globalMax = Math.max(globalMax,localSum);
        }
        return globalMax;
    }
	// Time: O(n), Space: O(1)
	
	
	public int maxSubArray2(int[] nums) {
        // prefix sum
        if (nums == null || nums.length == 0){
            return 0;
        }
        int result = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int num : nums){
            sum += num;
            result = Math.max(result, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return result;
    }
}
