package leetcode;
/*Given a string, find the length of the longest substring without repeating characters.
 * Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
"pwke" is a subsequence and not a substring.

Method: two pointers and HashMap to record char and its index
 */

import java.util.HashMap;
public class lc_003_longestSubstrNoRepeatStr {
	public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int ans = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);     // counter example "adbccba", Math.max guarantees moving one way
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans,i-j+1);
        }
        return ans;
    }
	// O(n) time, O(n) space
}
