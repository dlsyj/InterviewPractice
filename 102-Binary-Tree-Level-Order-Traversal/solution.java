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
        // BFS iterative
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<Integer>();
            for (int i = 0; i < currLevel; i ++){
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.add(currLevel);
        }
        return result;
    }
}