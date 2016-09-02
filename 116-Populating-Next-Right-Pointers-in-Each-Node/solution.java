/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null && root.left != null){
            TreeLinkNode current = root;
            while (current != null){
                current.left.next = current.right;
                current.right.next = current.next == null ? null : current.next.left;
                current = current.next;
            }
            root = root.left;
        }
    }
}