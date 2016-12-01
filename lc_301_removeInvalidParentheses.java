package leetcode;
/* Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

 * Method: DFS
 * https://discuss.leetcode.com/topic/30743/easiest-9ms-java-solution
 */
import java.util.*;
public class lc_301_removeInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<String>();
        int delLeft = 0, delRight = 0;
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '('){
                delLeft ++;
            }else if (s.charAt(i) == ')'){
                if (delLeft > 0){
                    delLeft --;
                }else{
                    delRight ++;
                }
            }
        }
        dfsHelper(result, s, 0, delLeft, delRight, 0, new StringBuilder());
        return new ArrayList<String>(result);
    }
    
    public void dfsHelper(Set<String> result, String s, int index, int delLeft, int delRight, int open, StringBuilder sb){
        if (index == s.length() && delLeft == 0 && delRight == 0 && open == 0){
            result.add(sb.toString());
            return;
        }
        if (index == s.length() || delLeft < 0 || delRight < 0 || open < 0){
            return;
        }
        char c = s.charAt(index);
        // record current length of string builder
        int lenCopy = sb.length();
        
        if (c == '('){
            dfsHelper(result, s, index + 1, delLeft - 1, delRight, open, sb);
            dfsHelper(result, s, index + 1, delLeft, delRight, open + 1, sb.append(c));
        }else if (c == ')'){
            dfsHelper(result, s, index + 1, delLeft, delRight - 1, open, sb);
            dfsHelper(result, s, index + 1, delLeft, delRight, open - 1, sb.append(c));
        }else{
            dfsHelper(result, s, index + 1, delLeft, delRight, open, sb.append(c));
        }
        sb.setLength(lenCopy);
    }
}
