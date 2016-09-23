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
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxPathSumDown(root);
        return maxValue;
    }
    public int maxPathSumDown(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = Math.max(0,maxPathSumDown(root.left));
        int rightSum = Math.max(0,maxPathSumDown(root.right));
        maxValue = Math.max(maxValue, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum,rightSum);
    }
}