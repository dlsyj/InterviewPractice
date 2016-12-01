package leetcode;
/* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 * 
 */
import java.util.*;
public class lc_268_missingNumber {
	public int missingNumber(int[] nums) {
        // XOR
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++){
            ans ^= i;
            ans ^= nums[i];
        }
        return ans;
    }
	
	public int missingNumber2(int[] nums) {
        // Binary Search
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] > mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
