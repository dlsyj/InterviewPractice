package leetcode;
/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Note: If the given node has no in-order successor in the tree, return null.
 * 
 * Method: The inorder traversal of a BST is the nodes in ascending order. 
 * To find a successor, you just need to find the smallest one that is larger than the given value 
 * since there are no duplicate values in a BST. It just like the binary search in a sorted list. 
 * The time complexity should be O(h) where h is the depth of the result node. 
 * succ is a pointer that keeps the possible successor. 
 * Whenever you go left the current root is the new possible successor, otherwise the it remains the same.

Only in a balanced BST O(h) = O(log n). In the worst case h can be as large as n.


 */
public class lc_285_inorderSuccessorInBST {
	// Iterative solution to find successor
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null){
            if (p.val < root.val){
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return succ;
    }
    
    // Iterative solution to find ancestor
    public TreeNode inorderAncestor(TreeNode root, TreeNode p){
    	if (root == null){
    		return null;
    	}
    	TreeNode ance = null;
    	while (root != null){
    		if (root.val < p.val){
    			ance = root;
    			root = root.right;
    		}else{
    			root = root.left;
    		}
    	}
    	return ance;
    }
    
    
    //Successor

    public TreeNode successor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;

      if (root.val <= p.val) {
        return successor(root.right, p);
      } else {
        TreeNode left = successor(root.left, p);
        return (left != null) ? left : root;
      }
    }
    // Predecessor

    public TreeNode predecessor(TreeNode root, TreeNode p) {
      if (root == null)
        return null;

      if (root.val >= p.val) {
        return predecessor(root.left, p);
      } else {
        TreeNode right = predecessor(root.right, p);
        return (right != null) ? right : root;
      }
    }
}
