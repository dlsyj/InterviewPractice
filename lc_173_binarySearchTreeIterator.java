package leetcode;
/* Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * 
 */
import java.util.*;
public class lc_173_binarySearchTreeIterator {
	private Stack<TreeNode> stack = null;
    private TreeNode curr = null;
    
    public lc_173_binarySearchTreeIterator(TreeNode root) {
        curr = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode temp = stack.pop();
        curr = temp.right;
        return temp.val;
    }
}
