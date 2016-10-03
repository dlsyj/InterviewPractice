public class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int oneSum = 0, iteration = 0, len = nums.length;
        for (int i = 0; i < len; i ++){
            oneSum += nums[i];
            iteration += nums[i] * i;
        }
        int result = iteration;
        for (int i = 1; i < len; i ++){
            iteration = iteration - oneSum + len * nums[i - 1];
            resut = Math.max(result,iteration);
        }
        return result;
    }
}