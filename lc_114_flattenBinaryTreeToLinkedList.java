package leetcode;
/* Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * 
 */
public class lc_114_flattenBinaryTreeToLinkedList {
	// Recursive
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
	
	// Iterative
	public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
}
