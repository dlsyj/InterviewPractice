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
    public int largestBSTSubtree(TreeNode root) {
       if(root == null) return 0;
       if(isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) return count(root);
       else return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
   }
    
   public int count (TreeNode n){
       if(n == null)
           return 0;
       return 1 + count(n.left) + count(n.right);
   }
   
   public boolean isValid(TreeNode n, int max, int min){
       if(n == null) return true;
       if(n.val < max && n.val > min) return isValid(n.left, n.val, min) && isValid(n.right, max, n.val);
       else return false;
   }
}