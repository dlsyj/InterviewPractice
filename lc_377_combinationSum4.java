package leetcode;
/*Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 * 
 */
import java.util.*;
public class lc_377_combinationSum4 {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0){
            return 0;
        }
        int result = 0;
        if (target == 0){
            return 1;
        }
        if (map.containsKey(target)){
            return map.get(target);
        }
        for (int num : nums){
            result += combinationSum4(nums, target - num);
        }
        map.put(target, result);
        return result;
    }
}
