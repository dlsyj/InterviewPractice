public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int leftPointer = 0, rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                // found 0, put it in the beginning
                swap(nums[i], nums[leftPointer++]);
            }else if (nums[i] == 2){
                // found 2, put it in the end
                swap(nums[i--], nums[rightPointer--]);
            }
        }
    }
    
    public void swap(int index1, int index2){
        int temp = index1;
        index1 = index2;
        index2 = temp;
    }
}