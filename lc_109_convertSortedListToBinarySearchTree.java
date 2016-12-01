package leetcode;
/* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST
 * 
 */
public class lc_109_convertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
        return helper(head,null);
    }
    public TreeNode helper(ListNode head, ListNode tail){
        if (head == null || head == tail){
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head,slow);
        root.right = helper(slow.next,tail);
        return root;
    }
}
