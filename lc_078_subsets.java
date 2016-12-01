package leetcode;
/*
 * Given a set of distinct integers, nums, return all possible subsets.
	Note: The solution set must not contain duplicate subsets.
	
	For example,
	If nums = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	
	Method: DFS, backtracking
	
	A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partitioning)
	https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
	
	// 复杂度？
 */
import java.util.*;
public class lc_078_subsets {
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(result, new ArrayList<>(), nums, 0);
	    return result;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<Integer>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
}
