public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int[] ans = new int[nums.length];
        int[] helper= new int[3];
        for (int i=0; i < nums.length; i++){
            helper[nums[i]]++;
        }
        helper[1] += helper[0];
        helper[2] += helper[1];
        for (int i=0; i < nums.length; i++){
            ans[helper[nums[i]]-1] = nums[i];
            helper[nums[i]]--;
        }
        for (int i=0; i<nums.length; i++){
            nums[i] = ans[i];
        }
    }
}