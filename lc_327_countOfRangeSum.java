package leetcode;
/* Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2
 * 
 * Method: TreeMap
 * // https://xuxinzhu0081.gitbooks.io/wtg/content/Contents/count-of-range-sum.html
 */
import java.util.*;
public class lc_327_countOfRangeSum {
	// brute force 
	public int countRangeSum1(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    int ans = 0;
	    for (int i = 0; i < n; ++i)
	        for (int j = i + 1; j <= n; ++j)
	            if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
	                ans++;
	    return ans;
	}
	
	// treemap
	public int countRangeSum(int[] nums, int lower, int upper) {
        
        if (nums == null || nums.length == 0){
            return 0;
        }
        long[] sums = new long[nums.length + 1];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i ++){
            sums[i] = sums[i - 1] + nums[i];
        }
        int result = 0;
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i ++){
            if (lower <= sums[i] && sums[i] <= upper){
                result ++;
            }
            for (int count : treeMap.subMap(sums[i] - upper,true, sums[i]- lower,true).values()){
                result += count;
            }
            Integer count = treeMap.get(sums[i]);
            count = count == null ? 1 : count + 1;
            treeMap.put(sums[i],count);
        }
        return result;
    }
}
