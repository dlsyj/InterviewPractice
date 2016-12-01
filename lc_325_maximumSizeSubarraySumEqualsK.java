package leetcode;
/*Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

 * Method: HashMap, Sum Up 
 */
import java.util.*;
public class lc_325_maximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
        for (int i = 1; i < nums.length; i ++){
            nums[i] += nums[i - 1];
        }
        map.put(0,-1);
        int result = 0;
        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(nums[i] - k)){
                result = Math.max(result, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
