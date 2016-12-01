package leetcode;
/* Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * Method: https://segmentfault.com/a/1190000003790309
 */
import java.util.*;
public class lc_163_missingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        long prev = lower - 1, curr = 0;
        for (int i = 0; i <= nums.length; i ++){
            curr = i == nums.length ? upper + 1 : nums[i];
            if (curr - prev > 1){
                result.add(getRange(prev+1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }
    public String getRange(long from, long to){
        return from == to ? String.valueOf(from) : from+"->"+to;
    }
}
