package leetcode;
/* Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * Method: Backtracking, based on subset I
 */
import java.util.*;
public class lc_090_subSet2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    Arrays.sort(nums);  //先排序来除重
	    backtrack(nums, result, new ArrayList<>(), 0);
	    return result;
	}

	private void backtrack(int [] nums, List<List<Integer>> result, List<Integer> curr,  int index){
	    
	    result.add(new ArrayList<Integer>(curr));
	    for(int i = index; i < nums.length; i ++){
	        if (i != index && nums[i] == nums[i - 1]){  // 原数列已排序
	            continue;
	        }
	        curr.add(nums[i]);
	        backtrack(nums, result, curr, i + 1);
	        curr.remove(curr.size() - 1);
	    }
	}
}
