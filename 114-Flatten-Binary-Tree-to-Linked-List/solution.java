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
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode rightNode = root.right;
        TreeNode leftNode = root.left;
        flatten(rightNode);
        flatten(leftNode);
        root.left = null;
        root.right = leftNode;
        while (root.right != null){
            root = root.right;
        }
        root.right = rightNode;
    }
}