package leetcode;
/* Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 */
import java.util.*;
public class lc_100_sameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
	
	// Iterative Solution (preorder)
	public boolean isSameTree2(TreeNode p, TreeNode q) {
        // Iterative Solution
        Stack<TreeNode> stack_p = new Stack<TreeNode>();
        Stack<TreeNode> stack_q= new Stack<TreeNode>();
        if (p != null){
            stack_p.push(p);
        }
        if (q != null){
            stack_q.push(q);
        }
        while (!stack_p.isEmpty() && !stack_q.isEmpty()){
            TreeNode cur_p = stack_p.pop();
            TreeNode cur_q = stack_q.pop();
            if (cur_p.val != cur_q.val){
                return false;
            }
            if (cur_p.left != null){
                stack_p.push(cur_p.left);
            }
            if (cur_q.left != null){
                stack_q.push(cur_q.left);
            } 
            if (stack_p.size() != stack_q.size()){
                return false;   // prune
            }
            if (cur_p.right != null){
                stack_p.push(cur_p.right);
            }
            if (cur_q.right != null){
                stack_q.push(cur_q.right);
            }
            if (stack_p.size() != stack_q.size()){
                return false;   // prune
            }
        }
        return stack_p.size() == stack_q.size();
    }
}
