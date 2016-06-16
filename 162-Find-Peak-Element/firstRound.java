public class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums,0,num.length-1);
    }
    
    public int helper(int[] num, int left, int right){
        if (left == right){
            return left;
        } else {
            int mid = left + (right-low)/2;
            if (num[mid] > num[mid+1]){
                return helper(num, left, mid);
            } else {
                return helper(num, mid+1, right);
            }
        }
    }
}