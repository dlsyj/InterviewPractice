package leetcode;
/* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * 
 */
import java.util.*;
public class lc_236_lowestCommonAncestorBinaryTree {
	// Recursive method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
    
 // Iterative method, 3种数据结构
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        parents.put(root,null);
        stack.push(root);
        while (!parents.containsKey(p) || !parents.containsKey(q)){
            TreeNode node = stack.pop();
            if (node.left != null){
                parents.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parents.put(node.right, node);
                stack.push(node.right);
            }
        }
        HashSet<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null){
            ancestors.add(p);
            p = parents.get(p);
        }
        while (!ancestors.contains(q)){
            q = parents.get(q);
        }
        return q;
    }
}
