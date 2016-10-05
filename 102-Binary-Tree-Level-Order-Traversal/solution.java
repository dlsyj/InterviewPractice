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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // DFS recursive
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfsHelper(result, root, 0);
        return result;
    }
    
    public void dfsHelper(List<List<Integer>> result, TreeNode root, int height){
        if (result.size() <= height){
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(root.val);
        dfsHelper(result, root.left, height + 1);
        dfsHelper(result, root.right, height + 1);
    }
}