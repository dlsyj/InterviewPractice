public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Corner Case
        if (nums1 == null || nums2 == null || m < n){
            return;
        }
         // keep three indexes: last index in nums1, last index in nums2, last index in result
        int index1 = m - 1, index2 = n - 1, indexAns = m + n - 1;
        while (index1 >= 0 && index2 >= 0){
            if (nums1[index1] > nums2[index2]){
                nums1[indexAns--] = nums1[index1--];
            }else{
                nums1[indexAns--] = nums2[index2--];
            }
        }
        while (index2 >= 0){
            nums1[indexAns--] = nums2[index2--];
        }
        return nums1;
    }
}