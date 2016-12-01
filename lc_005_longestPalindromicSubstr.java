package leetcode;
/*Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * Method: two pointers extend left and right separately
 */
public class lc_005_longestPalindromicSubstr {
	private int index, maxLen;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        for (int i=0; i < len-1; i++){
            extendPalindrome(s,i,i); // length of s is odd
            extendPalindrome(s,i,i+1);// length of s is even
        }
        return s.substring(index,index+maxLen);
    }
    
    public void extendPalindrome(String s, int left, int right){
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if (maxLen < right-left-1){ // notice after while loop, s.charAt(left) != s.charAt(right)
            index = left+1;
            maxLen = right-left-1;
        }
    }
    
    // Time: O(n^2), Space: O(1)
}
