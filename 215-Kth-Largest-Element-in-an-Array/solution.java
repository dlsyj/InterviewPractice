public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k){
            throw new Error();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}