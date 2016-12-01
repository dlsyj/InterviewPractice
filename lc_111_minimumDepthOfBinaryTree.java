package leetcode;
/* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 */
public class lc_111_minimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftNum = minDepth(root.left);
        int rightNum = minDepth(root.right);
        return (leftNum == 0 || rightNum == 0) ? leftNum + rightNum + 1 : Math.min(leftNum, rightNum) + 1;
    }
}
