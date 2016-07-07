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
        return helper(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd){
        if (postEnd < 0 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (root.val == inorder[i]){
                inIndex = i;
                break;
            }
        }
        root.left = helper(inorder,inStart,inIndex-1,postorder,postEnd-(inEnd-inIndex)-1);
        root.right = helper(inorder,inIndex+1,inEnd,postorder,postEnd-1);
        return root;
    }
}