package leetcode;
/* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * 
 */
import java.util.Stack;
public class lc_101_symmetricTree {
	// Recursive solution
	public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if (left == null || right == null){
            return left == right;
        }
        if (left.val != right.val){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
    
    // Iterative solution
    public boolean isSymmetric2(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode rightNode = stack.pop();
            TreeNode leftNode = stack.pop();
            if (leftNode == null && rightNode == null){
                continue; 
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }
            stack.push(leftNode.left);
            stack.push(rightNode.right);
            stack.push(leftNode.right);
            stack.push(rightNode.left);
        }
        return true;
    }
}
