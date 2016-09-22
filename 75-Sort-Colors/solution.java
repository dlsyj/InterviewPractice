public class Solution {
    public void sortColors(int[] A) {
        int j = 0, k = A.length -1;
    for (int i=0; i <= k; i++) {
        if (A[i] == 0)
            swap(A[i], A[j++]);
        else if (A[i] == 2)
            swap(A[i--], A[k--]);
    }
    }
    
    public void swap(int index1, int index2){
        int temp = index1;
        index1 = index2;
        index = temp;
    }
    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}