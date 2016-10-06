public class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long i = Math.abs((long)n);
        while(i > 0) {
            if((i & 1)==1) ans *= x;
            i >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}