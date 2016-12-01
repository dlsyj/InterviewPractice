package leetcode;
/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 *  Method: set up HashMap
 */
public class lc_409_longestPalindrome {
	public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()){
            count[c] += 1;
        }
        int result = 0;
        boolean hasOdd = false;
        for (int i = 0; i < 256; i ++){
            if (count[i] % 2 == 0){
                result += count[i];
            }else if (count[i] > 1){		// easy to forget. test case 'aaa' return 3
                result += count[i] - 1;
                hasOdd = true;
            }else{
                hasOdd = true;
            }
        }
        return hasOdd ? result + 1 : result;
    }
}
