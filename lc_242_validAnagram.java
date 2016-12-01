package leetcode;
/* Given two strings s and t, write a function to determine if t is an anagram of s.
For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 */
public class lc_242_validAnagram {
	public boolean isAnagram(String s, String t) {
        if (s == null || t == null){
            return s == t;
        }
        int[] arr = new int[26];
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i ++){
            arr[s.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j < t.length(); j ++){
            if (arr[t.charAt(j) - 'a'] <= 0){
                return false;
            }else{
                arr[t.charAt(j) - 'a']--;
            }
        }
        return true;
    }
}
