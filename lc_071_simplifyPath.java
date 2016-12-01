package leetcode;
/* Given an absolute path for a file (Unix-style), simplify it.
	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Case: Did you consider the case where path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".
 * Method: stack
 */
import java.util.*;
public class lc_071_simplifyPath {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (String each: path.split("/")){
            if (!each.equals(".") && !each.equals("") && !each.equals("..")){
                stack.push(each);
            }
            if (each.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }
        String result = "";
        for (String dir : stack){
            result += "/" + dir;
        }
        return stack.isEmpty() ? "/" : result;
    }
}
