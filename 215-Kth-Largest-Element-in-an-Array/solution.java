public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k){
            throw new Error();
        }
        int pos = quickSelect(nums, nums.length - k + 1, 0, nums.length - 1);
        return nums[pos];
    }
    public int quickSelect(int[] nums, int k, int left, int right){
        int i = left, j = right;
        int pivot = nums[right];
        while (i < j){
            if (pivot < nums[i]){
                j --;
                swap(nums, i, j);
            }else{
                i ++;
            }
        }
        swap(nums, i, right);
        int lessPivotNum = i - left + 1;
        if (lessPivotNum < k){
            return quickSelect(nums, k - lessPivotNum, i + 1, right);
        }else if (k < lessPivotNum){
            return quickSelect(nums, k, left, i - 1);
        }else{
            return i;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}