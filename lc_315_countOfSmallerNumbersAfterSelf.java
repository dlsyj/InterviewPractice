package leetcode;
/* You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
 * Method: (1)BST
 * Every node will maintain a val sum recording the total of number on it's left bottom side, dup counts the duplication. For example, [3, 2, 2, 6, 1], from back to beginning,we would have:

                1(0, 1)
                     \
                     6(3, 1)
                     /
                   2(0, 2)
                       \
                        3(0, 1)
When we try to insert a number, the total number of smaller number would be adding dup and sum of the nodes where we turn right.
for example, if we insert 5, it should be inserted on the way down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2), 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4

if we insert 7, the right-turning nodes are 1(0,1), 6(3,1), so answer should be (0 + 1) + (3 + 1) = 5

Method (2) Merge sort
 */
import java.util.*;
public class lc_315_countOfSmallerNumbersAfterSelf {
	public class Node{
        Node left, right;
        int val, leftNum, dup = 1;
        public Node(int val, int leftNum){
            this.val = val;
            this.leftNum = leftNum;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i --){
            root = insert(i, nums[i], root, result, 0);
        }
        return Arrays.asList(result);
    }
    
    public Node insert(int i, int num, Node node, Integer[] result, int curLeft){
        if (node == null){
            node = new Node(num, 0);
            result[i] = curLeft;
        }else if (node.val == num){
            node.dup ++;
            result[i] = curLeft + node.leftNum;
        }else if (num < node.val){
            node.leftNum ++;
            node.left = insert(i, num, node.left, result, curLeft);
        }else{
            node.right = insert(i, num, node.right, result, curLeft + node.dup + node.leftNum);
        }
        return node;
    }
}
