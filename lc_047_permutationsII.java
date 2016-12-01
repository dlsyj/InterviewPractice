package leetcode;
/*  Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	For example,
	[1,1,2] have the following unique permutations:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
 * Method: modify permutations for permutation II
 */
import java.util.*;
public class lc_047_permutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i < nums.length; i ++){
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j ++){
                for(List<Integer> each : result){
                    List<Integer> newEach = new ArrayList<Integer>(each);
                    newEach.add(j,nums[i]);
                    newResult.add(newEach);
                }
            }
            result = newResult;
        }
        HashSet<List<Integer>> distinctResult = new HashSet<List<Integer>>();
        for (List<Integer> each : result){
            distinctResult.add(each);
        }
        result.clear();
        for (List<Integer> each : distinctResult){
            result.add(each);
        }
        return result;
    }
}
