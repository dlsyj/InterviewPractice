public class Solution {
    public int jump(int[] nums) {
        int step = 0, pre = 0, cur = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > pre){
                step++;
                pre = cur;
                if (cur >= nums.length-1){
                    break;
                }
            }
            cur = Math.max(cur,nums[i]+i);
        }
        return step;
    }
}