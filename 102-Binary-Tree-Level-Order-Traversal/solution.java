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
        // DFS
        List<List<Integer>> wraplist = new ArrayList<List<Integer>>();
        helper(wraplist,root,0);
        return wraplist;
    }
    
    public void helper(List<List<Integer>> wraplist, TreeNode root, int height){
        if (root == null){
            return;
        }
        if (height >= wraplist.size()){
            wraplist.add(new ArrayList<Integer>());
        }
        wraplist.get(height).add(root.val);
        helper(wraplist,root.left,height+1);
        helper(wraplist,root.right,height+1);
    }
}