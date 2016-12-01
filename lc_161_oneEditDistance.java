package leetcode;
/* Given two strings S and T, determine if they are both one edit distance apart.

 * Method: two pointers
 */
public class lc_161_oneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenT < lenS){
            return isOneEditDistance(t, s);
        }
        if (lenT - lenS > 1){
            return false;
        }
        for (int i = 0; i < lenS; i ++){
            if (s.charAt(i) != t.charAt(i)){
                return s.substring(i).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return lenS + 1 == lenT;
    }
}
