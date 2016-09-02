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
        TreeLinkNode node = root;
        TreeLinkNode levelHead = new TreeLinkNode(0);
        while (node != null){
            TreeLinkNode needle = levelHead;
            while (node != null){
                if (node.left != null){
                    needle.next = node.left;
                    needle = needle.next;
                }
                if (node.right != null){
                    needle.next = node.right;
                    needle = needle.next;
                }
                node = node.next;
            }
            node = levelHead.next;
            levelHead.next = null;
        }
    }
}