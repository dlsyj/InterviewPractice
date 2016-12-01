package leetcode;
/* Implement int sqrt(int x).

Compute and return the square root of x.
 * Method: Binary
 */
public class lc_069_sqrtX {
	public int mySqrt(int x) {
        long left = 1, right = x;
        while (left + 1 < right){
            long mid = left +(right - left)/2;
            if (mid * mid <= x){
                left = mid;
            }else{
                right = mid;
            }
        }
        if (right * right <= x){
            return (int) right;
        }
        return (int) left;
    }
}
