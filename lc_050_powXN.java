package leetcode;
/* Implement pow(x, n).
 * 
 * Method: binary 
 */
public class lc_050_powXN {
	public double myPow(double x, int n) {
        double result = 1;
        long i = Math.abs((long)n);
        while (i != 0){
            if (i % 2 == 1){
                result *= x;
            }
            x *= x;
            i /= 2;
        }
        return n > 0 ? result : 1/result;
    }
}
