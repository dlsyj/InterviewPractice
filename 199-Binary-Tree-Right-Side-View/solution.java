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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int currLevNum = queue.size();
            for (int i = 0; i < currLevNum; i ++){
                TreeNode curr = queue.poll();
                if (i == currLevNum - 1){
                    result.add(curr.val);
                }
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return result;
    }
}