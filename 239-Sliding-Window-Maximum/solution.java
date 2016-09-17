public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null ||  nums.length == 0){
            return new int[0];
        }
        int len = nums.length;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] result = new int[len - k + 1];
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i ++){
            // remove elements whose index are out of range k
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            // compare last element and remove all elements less than it in range k
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1){
                result[resultIndex++] = nums[deque.peek()];
            }
        }
        return result;
    }
}