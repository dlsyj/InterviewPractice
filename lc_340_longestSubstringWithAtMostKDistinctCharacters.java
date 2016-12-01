package leetcode;
/* Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3

 *  Method: The main idea is to maintain a sliding window with 2 unique characters. 
 *  The key is to store the last occurrence of each character as the value in the hashmap. 
 *  This way, whenever the size of the hashmap exceeds 2, we can traverse through the map to find the character with the left most index, and remove 1 character from our map. 
 *  Since the range of characters is constrained, we should be able to find the left most index in constant time.

 */
import java.util.*;
public class lc_340_longestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() < 1) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0;
        int result = 0;
        while (high < s.length()){
            if (map.size() <= k){               // window not exceed
                char c = s.charAt(high);
                map.put(c, high);
                high ++;
            }
            if (map.size() > k){                  // window exceed
                int leftMost = s.length();
                for (int loc : map.values()){
                    leftMost = Math.min(leftMost, loc);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                low = leftMost + 1;
            }
            result = Math.max(result, high - low);
        }
        return result;
    }
}
