package leetcode;
/* Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * Method: DP
 */
public class lc_044_wildcardMatching {
	public boolean isMatch(String s, String p) {
        // https://www.youtube.com/watch?v=3ZDZ-N0EPV0
        if (s == null || p == null){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i ++){
            dp[i][0] = false;
        }
        for (int j = 1; j <= p.length(); j ++){
            dp[0][j] = p.charAt(j - 1) == '*' ? dp[0][j - 1] : false;
        }
        
        for (int i = 1; i <= s.length(); i ++){
            for (int j = 1; j <= p.length(); j ++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
