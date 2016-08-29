/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();
        DFShelper(wrapList,root,0,true);
        return wrapList;
    }
    public void DFShelper(List<List<Integer>> wrapList, TreeNode root, int height, boolean fromLeftToRight){
        if (root == null){
            return;
        }
        if (height >= wrapList.size()){
            wrapList.add(new ArrayList<Integer>());
        }
        if (fromLeftToRight){
            System.out.print("true: ");
            System.out.println(root.val);
            wrapList.get(height).add(root.val);
        } else {
            System.out.print("false: ");
            System.out.println(root.val);
            wrapList.get(height).add(0,root.val);
        }
        fromLeftToRight = fromLeftToRight? false: true;
        DFShelper(wrapList,root.left,height+1,fromLeftToRight);
        DFShelper(wrapList,root.right,height+1,fromLeftToRight);
    }
}