package leetcode;
/* Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 * Method: DFS, StringBuilder costs less than String
 */
import java.util.*;
public class lc_257_binaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfsHelper(root, sb, result);
        return result;
    }
    public void dfsHelper(TreeNode root, StringBuilder sb, List<String> result){
        if (root == null){
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null){
            result.add(sb.toString());
        }
        sb.append("->");
        dfsHelper(root.left, sb, result);
        dfsHelper(root.right, sb, result);
        sb.setLength(len);
    }
}
