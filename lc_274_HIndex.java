package leetcode;
/* Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

 * Method: bucket sort
 */
import java.util.*;
public class lc_274_HIndex {
	// brute force
	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0){
            return 0;
        }
        Arrays.sort(citations);
        int result = 0;
        for (int i = 0; i < citations.length; i ++){
            result = Math.max(result, Math.min(citations[i], citations.length - i));
        }
        return result;
    }
	
	public int hIndex2(int[] citations) {
        // bucket sort
        int len = citations.length;
        int[] buckets = new int[len+1];
        for (int citation : citations){
            if (citation > len){
                buckets[len] += 1;
            }else{
                buckets[citation] += 1;
            }
        }
        int count = 0;
        for (int i = len; i >= 0; i--){
            count += buckets[i];
            if (count >= i){
                return i;
            }
        }
        return 0;
    }
}
