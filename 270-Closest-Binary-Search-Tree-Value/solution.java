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
    public int closestValue(TreeNode root, double target) {
        // binary search iterative solution
        int result = root.val;
        while (root != null){
            if (Math.abs(target - root.val) < Math.abs(target - result)){
                result = root.val;   
            }
            if (target > root.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return result;
    }
}