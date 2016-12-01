package leetcode;
/* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class lc_088_mergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m+n-1; k >= 0; k--){
            if (i < 0)              A[k] = B[j--];
            else if (j < 0)         A[k] = A[i--];
            else if (A[i] < B[j])   A[k] = B[j--];
            else                    A[k] = A[i--];
        }
    }
}
