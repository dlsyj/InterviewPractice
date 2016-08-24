public class Solution {
    public int mySqrt(int x) {
        int res = 0;
        for (int mask = 1 << 15; mask != 0; mask >>>= 1) {
            int next = res | mask; //set bit
            if (next <= x / next) res = next;
        }
        return res;
    }
}