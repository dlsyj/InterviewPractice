public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }
        int leftPointer = 0, rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[leftPointer];
                nums[leftPointer] = temp;
                leftPointer++;
            }else if (nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[rightPointer];
                nums[rightPointer] = temp;
                i--;
                rightPointer--;
            }
        }
    }
}