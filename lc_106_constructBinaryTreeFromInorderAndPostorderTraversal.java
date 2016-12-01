package leetcode;
/* Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
 * Method: recursive solution
 */
public class lc_106_constructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length){
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd){
        if (postEnd >= postorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i ++){
            if (root.val == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = helper(inorder, inStart, index - 1, postorder, postEnd - inEnd + index - 1);
        root.right = helper(inorder, index + 1, inEnd, postorder, postEnd - 1);
        return root;
    }
}
