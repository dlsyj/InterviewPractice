package leetcode;
/*Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * 
 * Method: BFS, like lc_102_binary tree level order traversal
 */

import java.util.*;
public class lc_199_binaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int currLevelNum = queue.size();
            for (int i = 0; i < currLevelNum; i ++){
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if (i == currLevelNum - 1){
                    result.add(queue.peek().val);
                }
                queue.poll();
            }
            
        }
        return result;
    }
}
