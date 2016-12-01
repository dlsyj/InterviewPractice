package leetcode;
/* Given a binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path does not need to go through the root.
For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * Method: A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other nodes on the path.
A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input node, update maximum if necessary (2) returns the maximum sum of the path that can be extended to input node's parent.
 */
public class lc_124_binaryTreeMaximumPathSum {
	int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxPathSumDown(root);
        return maxValue;
    }
    public int maxPathSumDown(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftSum = Math.max(0,maxPathSumDown(root.left));
        int rightSum = Math.max(0,maxPathSumDown(root.right));
        maxValue = Math.max(maxValue, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum,rightSum);
    }
}
