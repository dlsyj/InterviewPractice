/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
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
        ListNode tail = reverse(mid);
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