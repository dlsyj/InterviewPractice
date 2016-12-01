package leetcode;
/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 * 
 * Method: (1)BFS with queue (2) DFS recursive
 */
import java.util.*;
public class lc_102_binaryTreeLevelOrderTraversal {
	// BFS with queue
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wraplist = new ArrayList<List<Integer>>();
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
                sublist.add(queue.poll().val);
            }
            wraplist.add(sublist);
        }
        return wraplist;
    }
	
	
	
	// DFS recursive
	public List<List<Integer>> levelOrder2(TreeNode root) {
        // DFS
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result,root,0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, TreeNode root, int height){
        if (root == null){
            return;
        }
        if (height >= result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(root.val);
        helper(result,root.left,height+1);
        helper(result,root.right,height+1);
    }
}
