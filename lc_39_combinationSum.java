package leetcode;
/*Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 * Method: Backtrack	
 */
import java.util.*;
public class lc_39_combinationSum {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), 0, target);
        return result;
    }
    
    public void helper(int[] nums, List<List<Integer>> result, ArrayList<Integer> curr, int index, int target){
        if (target > 0){
            for (int i = index; i < nums.length && target >= nums[i]; i ++){
                curr.add(nums[i]);
                helper(nums, result, curr, i, target - nums[i]);
                curr.remove(curr.size() - 1);
            }
        }else if (target == 0){
            result.add(new ArrayList<>(curr));
        }
        
    }
}
