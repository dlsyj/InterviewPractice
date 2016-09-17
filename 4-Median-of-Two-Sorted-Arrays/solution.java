public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2){
            // make sure nums2 is the shorter one
            findMedianSortedArrays(nums2,nums1);
        }
        int left = 0, right = len1 * 2;
        while (left <= right){
            int mid1 = (left + right)/2;
            int mid2 = len1 + len2 - mid1;
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(len1-1)/2];
            double R1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[len1/2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(len2-1)/2];
            double R2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[len2/2];
            // Because L1, L2 are the greatest numbers on the left halves and R1, R2 are the smallest numbers on the right,
            // L1 <= R1 && L1 <= R2 && L2 <= R1 && L2 <= R2
            if (L1 > R2){
                // A1's lower half is too big; need to move C1 left (C2 right)
                right = len1 - 1;
            } else if (L2 > R1){
                left = mid2 - 1;
            } else {
                return (Math.max(L1,L2) + Math.min(R1,R2))/2;
            }
        }
        return -1;
        // int N1 = nums1.length, N2 = nums2.length;
        // if (N1 > N2) return findMedianSortedArrays(nums2, nums1);
        
        // int lo = 0, hi = 2 * N1;
        // while (lo <= hi) {
        //     int C1 = (lo + hi) / 2;
        //     int C2 = N1 + N2 - C1;
            
        //     double L1 = (C1 == 0) ? Integer.MIN_VALUE : nums1[(C1-1)/2];
        //     double R1 = (C1 == 2*N1) ? Integer.MAX_VALUE : nums1[C1/2];
        //     double L2 = (C2 == 0) ? Integer.MIN_VALUE : nums2[(C2-1)/2];
        //     double R2 = (C2 == 2*N2) ? Integer.MAX_VALUE : nums2[C2/2];
            
        //     if (L1 > R2) hi = C1 - 1;
        //     else if (L2 > R1) lo = C1 + 1;
        //     else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        // }
        // return -1;
    }
}