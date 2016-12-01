package leetcode;
/* Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.


 * 
 */
public class lc_172_factorialTrailingZeroes {
	public int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}
