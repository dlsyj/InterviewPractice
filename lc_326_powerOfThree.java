package leetcode;
/* Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 * 
 */
public class lc_326_powerOfThree {
	public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n/3);
    }
	public boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 &&  1162261467%n==0);
    }
}
