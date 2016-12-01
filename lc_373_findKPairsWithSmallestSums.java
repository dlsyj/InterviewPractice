package leetcode;
/* You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
 * Method: Exactly same as LC_378_K th Smallest Element in a sorted array
 */
import java.util.*;
public class lc_373_findKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0){
            return result;
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = nums1.length, n = nums2.length;
        for (int j = 0; j < n; j ++){
            pq.offer(new Tuple(0,j,nums1[0] + nums2[j]));
        }
        for (int i = 0; i < Math.min(k, m*n); i ++){
            Tuple curr = pq.poll();
            result.add(new int[]{nums1[curr.x],nums2[curr.y]});
            if (curr.x == m - 1){
                continue;
            }
            pq.offer(new Tuple(curr.x + 1, curr.y, nums1[curr.x + 1] + nums2[curr.y]));
        }
        return result;
    }
    
    public class Tuple implements Comparable<Tuple>{
        int x, y, val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }
}
