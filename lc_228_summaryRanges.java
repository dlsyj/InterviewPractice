package leetcode;
/* Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 */
import java.util.*;
public class lc_228_summaryRanges {
	public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int startIdx = 0;
        for (int i = 0; i < nums.length; i ++){
            startIdx = i;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]){
                i++;
            }
            if (i > startIdx){
                result.add(nums[startIdx] + "->" + nums[i]);
            }else if (i == startIdx){
                result.add(String.valueOf(nums[startIdx]));
            }
        }
        return result;
    }
}
