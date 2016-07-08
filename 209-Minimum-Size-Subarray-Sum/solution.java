public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE , left = 0, right = 0, sum = 0;
        while (right < nums.length){
            sum += nums[right++];   // move right pointer and update sum
            while (sum >= s){          // when current sum >= s
                min = Math.min(min,right-left);
                sum -= nums[left++];    // move left pointer and minus value at left pointer
            }
        }
        return min == Integer.MAX_VALUE ? 0:min;
        // Attention: time complexity is O(n) not O(n^2)
    }
}