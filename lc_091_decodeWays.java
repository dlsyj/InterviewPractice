package leetcode;
/* A message containing letters from A-Z is being encoded to numbers using the following mapping:
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	The number of ways decoding "12" is 2.
	
 * Method: I used a dp array of size n + 1 to save subproblem solutions. 
 * dp[0] means an empty string will have one way to decode, 
 * dp[1] means the way to decode a string of size 1. 
 * I then check one digit and two digit combination and save the results along the way. 
 * In the end, dp[n] will be the end result.
 * 123
 *   i
 * one : 2
 * two : 12
 */
public class lc_091_decodeWays {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // '0' not 0!!!
        for (int i = 2; i <= s.length(); i ++){
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigits = Integer.valueOf(s.substring(i-2,i));
            if (oneDigit != 0){
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
	// Time O(n) SpaceO(n+1)
}
