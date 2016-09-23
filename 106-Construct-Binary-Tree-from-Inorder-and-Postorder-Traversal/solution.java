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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length){
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart){
        if (postStart >= postorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i ++){
            if (root.val == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = helper(inorder, inStart, index - 1, postorder, index - inStart);
        root.right = helper(inorder, index + 1, inEnd, postorder, postStart - 1);
        return root;
    }
}