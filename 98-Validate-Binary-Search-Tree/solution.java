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
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (prev != null && curr.val <= prev.val){
                return false;
            }
            prev = curr;
            root = curr.right;
        }
        return true;
    }

}