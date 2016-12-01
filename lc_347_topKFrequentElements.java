package leetcode;
/* Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * Method: HashMap<num,freq>, min heap
 */
import java.util.*;
public class lc_347_topKFrequentElements {
	 // Bucket Sort, O(n) time
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int maxCount = 0;
        for (int num : nums){
            map.putIfAbsent(num,0);
            map.put(num, map.get(num) + 1);
            maxCount = Math.max(maxCount, map.get(num));
        }
        List<Integer>[] bucket = new List[maxCount + 1];
        for (int key : map.keySet()){
            int count = map.get(key);
            if (bucket[count] == null){
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(key);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i --){
            if (bucket[i] != null){
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
	
	// A excellent to sort HashMap by value with ProrityQueue
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        // to find max frequency, use min heap
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.add(0,pq.poll().getKey());   // min heap, put it at start
        }
        return result;
    }
}
