package leetcode;
/* Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28
 * 
 */
import java.util.*;
public class lc_421_maximumXOROfTwoNumbersInAnArray {
	public int findMaximumXOR(int[] nums) {
        int result = 0, mask = 0 ;
        for (int i = 31; i >= 0; i --){
            mask |= (1 << i);       // 移位要括号
            Set<Integer> set = new HashSet<Integer>();
            for (int each : nums){
                set.add(each & mask);
            }
            int temp = result | (1 << i);
            for (int each : set){
                if (set.contains(each ^ temp)){
                    result = temp;
                }
            }
        }
        return result;
    }
}
