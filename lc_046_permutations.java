package leetcode;
/* Given a collection of distinct numbers, return all possible permutations.
	For example,
	[1,2,3] have the following permutations:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]

 * Method: The basic idea is, to permute n numbers, we can add the nth number into the resulting List<List<Integer>> from the n-1 numbers, in every possible position.
For example, if the input num[] is {1,2,3}: First, add 1 into the initial List<List<Integer>> (let's call it "answer").
Then, 2 can be added in front or after 1. So we have to copy the List<Integer> in answer (it's just {1}), add 2 in position 0 of {1}, then copy the original {1} again, and add 2 in position 1. Now we have an answer of {{2,1},{1,2}}. There are 2 lists in the current answer.
Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0; then copy {2,1} and {1,2}, and add 3 into position 1, then do the same thing for position 3. Finally we have 2*3=6 lists in answer, which is what we want.


 */
import java.util.*;
public class lc_046_permutations {
	// Iteration
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i < nums.length; i ++){
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j ++){
                for (List<Integer> each : result){
                    List<Integer> newEach = new ArrayList<Integer>(each);
                    newEach.add(j,nums[i]);
                    tempResult.add(newEach);
                }
            }
            result = tempResult;
        }
        return result;
    }
	
	// Recursion
	public List<List<Integer>> permuteRecursion(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        backTracking(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    public void backTracking(List<List<Integer>> result, int[] nums, List<Integer> current, int index){
        if (current.size() == nums.length){
            result.add(current);
            return;
        }
        for (int j = 0; j <= current.size(); j ++){
            List<Integer> newCopy = new ArrayList<Integer>(current);
            newCopy.add(j, nums[index]);
            backTracking(result, nums, newCopy, index + 1);
        }
		
	}
	
}
