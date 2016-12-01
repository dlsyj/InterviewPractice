package leetcode;
/* Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
 * Method: Binary Search
 */
public class lc_275_HIndex2 {
	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0){
            return 0;
        }
        int len = citations.length, left = 0, right = len;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid){
                return len - mid;
            }else if (citations[mid] < len - mid){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return len - left;
    }
}
