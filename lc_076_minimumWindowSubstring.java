package leetcode;
/* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * Method :https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
 */
public class lc_076_minimumWindowSubstring {
	public String minWindow(String s, String t) {
        int[] count = new int[256];
        for (char each : t.toCharArray()){
            count[each] ++;
        }
        int temp = t.length(), min = Integer.MAX_VALUE, from = 0;
        for (int i = 0, j = 0; i < s.length(); i ++){
            if (count[s.charAt(i)] -- > 0){
                temp --;
            }
            while (temp == 0){
                if (i - j + 1 < min){
                    min = i - j + 1;
                    from = j;
                }
                if (count[s.charAt(j++)] ++ >= 0){
                    temp ++;
                }
            }
        }
        return min == Integer.MAX_VALUE? "" : s.substring(from,from+min);
    }
}
