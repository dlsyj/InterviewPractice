/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> stack = null;
    private TreeNode curr = null;
    
    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || curr;
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode temp = stack.pop();
        curr = temp.right;
        return temp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */