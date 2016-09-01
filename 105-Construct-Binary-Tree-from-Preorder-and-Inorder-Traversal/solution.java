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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length){
            return null;
        }
        return helper(preorder,0,inorder,0,inorder.length);
    }
    
    public TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd){
        if (preStart >= preorder.length || inStart >= inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i < inEnd; i++){
            if (root.val == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = helper(preorder,preStart+1,inorder,inStart,index-1);
        root.right = helper(preorder,preStart+index-inStart,inorder,index+1,inEnd);
        return root;
    }
}