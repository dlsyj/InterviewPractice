package leetcode;
/*Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 * 
 * Method: https://discuss.leetcode.com/topic/53753/brief-explanation-for-reservoir-sampling
 * Union find
 */
public class lc_382_linkedListRandomNode {
	public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i ++){
            roots[i] = i;
        }
        for (int[] edge : edges){
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);
            if (root1 != root2){
                roots[root1] = root2;   // union
                n --;
            }
        }
        return n;
    }
    
    public int find(int[] roots, int id){
        while (id != roots[id]){
            id = roots[id];
        }
        return id;
    }
}
