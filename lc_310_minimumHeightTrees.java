package leetcode;
/* For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]
 * 
 */
import java.util.*;
public class lc_310_minimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n == 0) return new ArrayList<>();
        else if (n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }
        List<Set<Integer>> adj = new ArrayList<>(n);
        // initialize List<Set<Integer>>
        for (int i = 0; i < n; i ++){
            adj.add(new HashSet<Integer>());
        }
        // store edges into adj 
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // find leaves
        for (int i = 0; i < n; i ++){
            if (adj.get(i).size() == 1){
                leaves.add(i);
            }
        }
        // eat all leaves at the same time and update leaves
        while (n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int leaf : leaves){
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
