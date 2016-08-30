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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS iterative solution
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new ArrayList<List<Integer>>();
        boolean fromLeftToRight = true;
        if (root == null){
            return wraplist;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> sublist = new ArrayList<Integer>();
            for (int i = 0; i < levelNum; i++){
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if (fromLeftToRight){
                    sublist.add(queue.poll().val);
                } else {
                    sublist.add(0,queue.poll().val);
                }
            }
            fromLeftToRight = fromLeftToRight ? false:true;
            wraplist.add(sublist);
        }
        return wraplist;
    }
}