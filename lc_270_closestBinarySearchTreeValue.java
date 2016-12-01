package leetcode;
/* Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Method: Binary Search
 */
public class lc_270_closestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
        // binary search iterative solution
        int result = root.val;
        while (root != null){
            if (Math.abs(target - root.val) < Math.abs(target - result)){
                result = root.val;   
            }
            if (target > root.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return result;
    }
}
