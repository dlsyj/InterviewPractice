public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int step = 0, curReached = 0, nextReached = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > curReached){
                step++;
                curReached = nextReached;
                if (nextReached >= nums.length-1){
                    break;
                }
            }
            nextReached = Math.max(nextReached,nums[i]+i);
        }
        return step;
    }
}