package leetcode;
/* One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 * 
 * Method: If we treat null's as leaves, then the binary tree will always be full. 
 * A full binary tree has a good property that # of leaves = # of nonleaves + 1. 
 * Since we are given a pre-order serialization, we just need to find the shortest prefix of the serialization sequence satisfying the property above. 
 * If such prefix does not exist, then the serialization is definitely invalid; otherwise, the serialization is valid if and only if the prefix is the entire sequence.
 */
public class lc_331_verifyPreorderSerializationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
        int nonleaves = 0, leaves = 0, i = 0;
        String[] nodes = preorder.split(",");
        for (i = 0; i < nodes.length && nonleaves + 1 != leaves; i ++){
            if (nodes[i].equals("#")){
                leaves ++;
            }else{
                nonleaves ++;
            }
        }
        return nonleaves + 1 == leaves && i == nodes.length;
    }
}
