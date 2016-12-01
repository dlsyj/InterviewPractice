package leetcode;
/*Given a singly linked list, determine if it is a palindrome.
 * 
 * Method: Reverse Linked List and then judge
 */
public class lc_234_palindromeLinkedList {
	public ListNode reverseLinkedList(ListNode head){
		ListNode prev = null;
		while (head != null){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	
	public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode fast = head.next;
        ListNode mid = head;
        // find mid node, using fast slow pointers
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            mid = mid.next;
        }
        // reverse mid right half
        ListNode tail = reverseLinkedList(mid);
        // compare (1)tail to mid with (2)head to mid
        while (tail != null && head != null){
            if (tail.val != head.val){
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }
}
