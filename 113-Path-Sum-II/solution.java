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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentResult = new ArrayList<Integer>();
        helper(root, sum, result, currentResult);
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currentResult){
        if (root == null){
            return;
        }
        currentResult.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            result.add(new ArrayList(currentResult));
        }
        helper(root.left, sum - root.val, result, currentResult);
        helper(root.right, sum - root.val, result, currentResult);
        currentResult.remove(currentResult.size() - 1);
    }
}