package leetcode;
/* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * 
 */
import java.util.*;
public class lc_113_pathSum2 {
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
