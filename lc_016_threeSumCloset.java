package leetcode;
/* Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
import java.util.*;
public class lc_016_threeSumCloset {
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);  // SORT firstly
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target-sum) < Math.abs(target-result)){
                    result = sum;
                }
                if (sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
