package leetcode;
/* Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * 
 */
import java.util.*;
public class lc_40_combinationSum2 {
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), 0, target);
        return result;
    }
    
    public void helper(int[] nums, List<List<Integer>> result, ArrayList<Integer> curr, int index, int target){
        if (target > 0){
            for (int i = index; i < nums.length && target >= nums[i]; i ++){
                if (i > index && nums[i] == nums[i - 1]){       // only one more if judgement
                    continue;
                }
                curr.add(nums[i]);
                helper(nums, result, curr, i + 1, target - nums[i]);
                curr.remove(curr.size() - 1);
            }
        }else if (target == 0){
            result.add(new ArrayList<>(curr));
        }else{
            return;
        }
    }
}
