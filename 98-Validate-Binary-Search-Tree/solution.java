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
    public boolean isValidBST(TreeNode root) {
        // Iterative Solution
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode preNode = null;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (preNode != null && curr.val <= preNode.val){
                return false;
            }
            preNode = curr;
            root = curr.right;
            
        }
        return true;
    }

}