package leetcode;
/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Ask: Note: The solution set must not contain duplicate triplets?
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * 
 * Method: SORT firstly, and scan with two pointers, 
 * Attention: skip duplicated numbers
 */
import java.util.*;
public class lc_015_threeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);  // SORT firstly
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue; // to skip duplicated numbers, e.g [0,0,0]
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){  // to skip duplicated numbers
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){   // to skip duplicated numbers
                        right--;
                    }
                }else if (sum < 0){
                    left ++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }
	// Time: O(n^2), Space: O(1)
}
