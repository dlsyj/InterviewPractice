package leetcode;
/* Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 * 
 */
public class lc_110_balancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right) > 1){
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
