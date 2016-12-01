package leetcode;
/* Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 * 
 */
public class lc_105_constructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length){
            return null;
        }
        return helper(preorder,0,inorder,0,inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd){
        if (preStart >= preorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (root.val == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = helper(preorder,preStart+1,inorder,inStart,index-1);
        root.right = helper(preorder,preStart+index-inStart+1,inorder,index+1,inEnd);
        return root;
    }
}
