/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }
    public ListNode partition(ListNode[] lists, int left, int right){
        if (left == right){
            return lists[left];
        }
        if (left < right){
            int mid = left + (right - left) / 2;
            ListNode leftNode = partition(lists, left, mid);
            ListNode rightNode = partition(lists, mid + 1, right);
            return mergeTwoLists(leftNode, rightNode);
        } else {
            return null;
        }
    } 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}