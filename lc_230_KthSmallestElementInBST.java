package leetcode;
/* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Show Hint 

 * 
 */
import java.util.*;
public class lc_230_KthSmallestElementInBST {
	// DFS in-order recursive
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countNode(root.left);
        if (k <= leftCount){
            return kthSmallest(root.left,k);
        } else if (leftCount + 1 < k){
            return kthSmallest(root.right,k-leftCount-1);
        } else {
            return root.val;
        }
    }
    
    public int countNode(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }
    
 // DFS in-order iterative
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }
        while (k != 0){
            TreeNode curr = stack.pop();
            k --;
            if (k == 0){
                return curr.val;
            }
            TreeNode right = curr.right;
            while (right != null){
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
