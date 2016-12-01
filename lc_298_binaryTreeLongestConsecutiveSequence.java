package leetcode;
/* Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * Method: recursive dfs
 */
public class lc_298_binaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root, root.left, 1),dfs(root,root.right,1));
    }
    public int dfs(TreeNode root, TreeNode child, int value){
        if (child == null){
            return value;
        }
        value = root.val + 1 == child.val ? value + 1 : 1;
        return Math.max(Math.max(dfs(child, child.left,value), dfs(child,child.right, value)),value);
    }
}
