package leetcode;
/* Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

Methoud: Reservoir Sampling
 * 
 */
import java.util.*;
public class lc_398_randomPickIndex {
private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    
    public lc_398_randomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            if (!map.containsKey(num)){
                map.put(num, new ArrayList<Integer>());
            }
            map.get(num).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> currList = map.get(target);
        int i = (int) (Math.random() * currList.size());
        return currList.get(i);
    }
}
