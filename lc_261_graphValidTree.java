package leetcode;
/* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree? No!!!!
n - 1 == edges.length

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Method: (1) Union find
 */
import java.util.*;
public class lc_261_graphValidTree {
	public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i ++){
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x == y){
                return false;
            }
            nums[x] = y;
        }
        return n - 1 == edges.length;
    }
    
    public int find(int[] nums, int x){
        if (nums[x] == -1){
            return x;
        }
        return find(nums, nums[x]);
    }
}
