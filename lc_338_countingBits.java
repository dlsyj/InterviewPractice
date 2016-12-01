package leetcode;
/* Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

O(n*sizeof(integer))很简单 But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
 * Method: DP
 * https://discuss.leetcode.com/topic/40195/how-we-handle-this-question-on-interview-thinking-process-dp-solution
 */
public class lc_338_countingBits {
	public int[] countBits(int num) {
        // DP, dp[i] = dp[i - offset] + 1
        int[] result = new int[num+1];
        int offset = 1;
        for (int i = 1; i <= num; i ++){
            if (i >= offset * 2){
                offset *= 2;
            }
            result[i] = result[i - offset] + 1;
        }
        return result;
    }
}
