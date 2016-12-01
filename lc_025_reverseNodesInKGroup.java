package leetcode;
/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

Method: recursive solution based on reverse linked list
 */
public class lc_025_reverseNodesInKGroup {
	
	public ListNode reverseNodesInKGroup(ListNode head, int k){
		int count = 0;
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null && count < k){
			count ++;
			prev = curr;
			curr = curr.next;
		}
		if (count == k){
			prev.next = null;
			reverseList(head);
			head.next = reverseNodesInKGroup(curr, k);
			return prev;
		} else {
			return head;
		}
	}
	
	public ListNode reverseList(ListNode head){
		ListNode prev = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}
