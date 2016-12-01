package leetcode;
/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * Method: backtracking
 */
import java.util.*;
public class lc_022_generateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result, "", n, n, n);
        return result;
    }
    
    public void dfs(List<String> result, String curr, int open, int close, int n){
        if (curr.length() == 2 * n){
            result.add(curr);
            return;
        }
        // easy to forget if conditions
        if (open >= 1) dfs(result, curr + "(", open - 1, close, n);
        if (close > open) dfs(result, curr + ")", open, close - 1, n);
    }
}
