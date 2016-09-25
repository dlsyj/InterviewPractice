public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int rob = 0;
        int notRob = 0;
        for (int i = 0; i < nums.length; i ++){
            int currRob = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = currRob;
        }
        return Math.max(rob, notRob);
    }
}