package leetcode;
/* Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]

 * Method: Use DP to track max Set and pre index.
 */
import java.util.*;
public class lc_368_largestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int maxLen = 0, index = -1;
        Arrays.fill(count,1);   // fill 1 not 0
        Arrays.fill(pre,-1);
        Arrays.sort(nums);  // easy to forget
        for (int i = 0; i < nums.length; i ++){
            for (int j = i - 1; j >= 0; j --){
                if (nums[i] % nums[j] == 0){
                    if (count[j] + 1 > count[i]){
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > maxLen){
                maxLen = count[i];
                index = i;
            }
        }
        while (index != -1){
            result.add(nums[index]);
            index = pre[index];
        }
        return result;
    }
}
