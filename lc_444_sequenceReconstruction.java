package leetcode;
/* Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true
 * Method: (1)Brute force
 * 首先建立原始序列org中各元素到其下标的映射indexes。

遍历seqs，记当前序列为seq，遍历seq；

记seq中相邻元素为pre, cur，若indexes[pre] > indexes[cur]，说明与org中各元素的前后关系产生矛盾，返回False

否则，将(pre, cur)加入边集edges。

最后遍历org，判断其中两两相邻元素构成的边是否都在edges中，若是返回True，否则返回False。
(2) Topological sort 好难，待优化代码

 */
import java.util.*;
public class lc_444_sequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Topological Sort solution 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        // indegree of each node
        for (int[] seq : seqs){
            for (int i : seq){
                indegree.putIfAbsent(i,0);
                graph.putIfAbsent(i, new ArrayList<>());
            }
        }
        
        // Initialize graph map
        for (int[] seq : seqs){
            for (int i = 1; i < seq.length; i ++){
                int from = seq[i - 1], to = seq[i];
                graph.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
            }
        }
        
        // check number of nodes
        if(org.length != indegree.size()){
            return false;
        }
        
        // find the head of sequence
        int head = -1;
        for(int node : indegree.keySet()){
            int indeg = indegree.get(node);
            if (indeg == 0 && head != -1){  // multiple head
                return false;
            }
            if (indeg == 0){
                head = node;
            }
        }
        if (head == -1){    // no head
            return false;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int[] level = new int[org.length + 1];
        level[head] = -1;
        q.offer(head);
        
        Set<Integer> visited = new HashSet<Integer>();
        while (!q.isEmpty()){
            int curr = q.poll();
            visited.add(curr);
            for (int next : graph.get(curr)){
                level[next] = curr;
                if (!visited.contains(next)){
                    q.offer(next);
                }
            }
        }
        
        for (int i = 1; i < org.length; i ++){
            if (level[org[i]] != org[i - 1]){
                return false;
            }
        }
        return true;
    }
}
