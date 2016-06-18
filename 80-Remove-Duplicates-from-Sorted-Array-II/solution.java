public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int ans = 1;
        int duplicatedNum = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[ans++] = nums[i];
                duplicatedNum = 0;
            } else {
                duplicatedNum ++;
                if (duplicatedNum <= 1){
                    nums[ans++] = nums[i];
                } 
            }
        }
        return ans;
    }
}