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
        // A dummy head node is brought here
        if(root == null)
            return;
        TreeLinkNode dummy = new TreeLinkNode(0);
        dummy.next = root;
        while(dummy.next != null){
            TreeLinkNode cur = dummy.next, pre = dummy;
            dummy.next = null;
            while(cur != null){
                if(cur.left != null)
                    pre = pre.next;
                    pre.next = cur.left;
                if(cur.right != null)
                    pre = pre.next;
                    pre.next = cur.right;
                cur = cur.next;
            }
        }
    }
}