/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
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