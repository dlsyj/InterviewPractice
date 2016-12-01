package leetcode;
/* Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * 
 */
public class lc_117_populatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
        TreeLinkNode curr = root;
        TreeLinkNode nextLevelHead = new TreeLinkNode(0);
        while (curr != null){
            TreeLinkNode needle = nextLevelHead;
            while (curr != null){
                if (curr.left != null){
                    needle.next = curr.left;
                    needle = needle.next;
                }
                if (curr.right != null){
                    needle.next = curr.right;
                    needle = needle.next;
                }
                curr = curr.next;
            }
            curr = nextLevelHead.next;
            nextLevelHead.next = null;
        }
    }
}
