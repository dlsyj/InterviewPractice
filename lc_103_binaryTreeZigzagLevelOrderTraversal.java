package leetcode;
/* Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 * 
 */
import java.util.*;
public class lc_103_binaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// BFS iterative solution
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean fromLeftToRight = true;
        if (root == null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> currLevel = new ArrayList<Integer>();
            for (int i = 0; i < levelNum; i++){
                TreeNode curr = queue.poll();
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
                if (fromLeftToRight){
                    currLevel.add(curr.val);
                } else {
                    currLevel.add(0,curr.val);
                }
            }
            fromLeftToRight = fromLeftToRight ? false:true;
            result.add(currLevel);
        }
        return result;
    }
	
	// Recursive solution
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();
        DFShelper(wrapList,root,0,true);
        return wrapList;
    }
    public void DFShelper(List<List<Integer>> wrapList, TreeNode root, int height, boolean fromLeftToRight){
        if (root == null){
            return;
        }
        if (height >= wrapList.size()){
            wrapList.add(new ArrayList<Integer>());
        }
        if (fromLeftToRight){
            wrapList.get(height).add(root.val);
        } else {
            wrapList.get(height).add(0,root.val);
        }
        fromLeftToRight = fromLeftToRight? false: true;
        DFShelper(wrapList,root.left,height+1,fromLeftToRight);
        DFShelper(wrapList,root.right,height+1,fromLeftToRight);
    }
}
