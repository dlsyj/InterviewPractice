package leetcode;
/* Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]

 * Method: HashMap 
 */
import java.util.*;
public class lc_314_binaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        queue.offer(root);
        column.offer(0);
        int min = 0, max = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = column.poll();
            if (!map.containsKey(col)){
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);
            
            if (node.left != null){
                queue.offer(node.left);
                column.offer(col - 1);
                if (col - 1 < min){
                    min = col - 1;
                }
            }
            
            if (node.right != null){
                queue.offer(node.right);
                column.offer(col + 1);
                if (col + 1 > max){
                    max = col + 1;
                }
            }
        }
        
        for (int i = min; i <= max; i ++){
            result.add(map.get(i));
        }
        return result;
    }
}
