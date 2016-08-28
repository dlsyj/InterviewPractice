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
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
                return false;
            }
            if (cur_p.right != null){
                stack_p.push(cur_p.right);
            }
            if (cur_q.right != null){
                stack_q.push(cur_q.right);
            }
            if (stack_p.size() != stack_q.size()){
                return false;
            }
        }
        return stack_p.size() == stack_q.size();
    }
}