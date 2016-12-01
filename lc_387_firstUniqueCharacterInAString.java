package leetcode;
/* Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 * Method 1: Two arrays, one for freq, another one for location, Method 2: LinkedHashMap
 * LinkedHashMap extends HashMap and maintains a linked list of the entries in the map, 
 * in the order in which they were inserted. 
 * This allows insertion-order iteration over the map. 
 * That is, when iterating a LinkedHashMap, the elements will be returned in the order in which they were inserted.
 */
import java.util.*;
public class lc_387_firstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (set.contains(curr)) {
                map.remove(curr);
            } else {
                map.put(curr, i);
                set.add(curr);
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
	
	public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int[] freq = new int[26];
        int[] loc = new int[26];
        for (int i = 0; i < s.length(); i ++){
            char curr = s.charAt(i);
            freq[curr - 'a'] ++;
            loc[curr - 'a'] = i;
        }
        int result = -1;
        for (int i = 0; i < 26; i ++){
            if (freq[i] == 1){
                result = result == -1? loc[i] : Math.min(loc[i], result);
            }
        }
        return result;
    }
}
