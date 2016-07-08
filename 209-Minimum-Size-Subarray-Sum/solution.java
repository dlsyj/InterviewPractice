public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        // O(nlogn) solution, and need O(n) space
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int minWindow = len+1;
        int[] accumulatedSum = new int[len+1];
        
        for (int i = 1; i <= len; i++){
            // each element in accumulateSum is sum from nums[0 to i-1]
            accumulatedSum[i] = accumulatedSum[i-1] + nums[i-1];  
        }
        
        for (int i = 0; i <= len; i++){
            int rightIndex = findRight(i+1,len+1,accumulatedSum[i]+s,accumulatedSum);
            if (rightIndex == len+1){
                break;
            }
            minWindow = Math.min(minWindow,rightIndex-i);
        }
        return minWindow == len+1 ? 0 : minWindow;
    }
    
    public int findRight(int left, int right, int target, int[] accumulatedSum){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (accumulatedSum[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    
}