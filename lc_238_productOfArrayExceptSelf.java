package leetcode;
/* Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * 
 * Method: You traverse twice, applying the appropriate multiplier.
 */
public class lc_238_productOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0){
            return result;
        }
        // the running product of the part before the current number.
        int prefix = 1;
        for (int i = 0; i < nums.length; i ++){
            result[i] = prefix;
            prefix *= nums[i];
        }
        // the running product of the part after the current number.
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i --){
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
	
	// Follow up, no extra space
	
}
