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
        // Interation Solution
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || curr != null){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (pre != null && node.val <= pre.val){
                    return false;
                }
                pre = node;
                curr = node.right;
            }
        }
        return true;
    }

}