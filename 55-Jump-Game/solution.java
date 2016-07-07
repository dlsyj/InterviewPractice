public class Solution {
    public boolean canJump(int[] nums) {
        int maxReached = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > maxReached){
                return false;
            }
            maxReached = Math.max(nums[i]+i, maxReached);
        }
        return true;
    }
}