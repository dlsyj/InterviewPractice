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
        helper(inorder,0,inorder.length,preorder,0);
    }
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart){
        // Ending condition for recursion
        if (preStart > preorder.length || inStart > inEnd){
            return null;
        }
        // First element in preorder is root of Binary Tree
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        // First root in inorder to split left and right sub-trees
        for (int i = inStart; i < inEnd; i++){
            if (root.val == inorder[i]){
                inIndex = i;
                break;
            }
        }
        root.left = helper(inorder,inStart,inIndex-1,preorder,preStart+1);
        root.right = helper(inorder,inIndex+1,inEnd,preorder,preStart+inIndex-inStart+1);
        return root;
    }
}