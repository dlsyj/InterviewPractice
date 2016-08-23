public class Solution {
    public int maxSubArray(int[] nums) {
        // Greedy
        if (nums == null || nums.length == 0){
            return 0;
        }
        int globalMax = Integer.MIN_VALUE, localSum = 0;
        for (int each : nums){
            localSum += each;
            globalMax = Math.max(globalMax,sum);
            localSum = Math.max(localSum,0);
        }
        return globalMax;
    }
}