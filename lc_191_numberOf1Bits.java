package leetcode;
/* Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.


 * 
 */
public class lc_191_numberOf1Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0){
            result ++;
            n = n & (n - 1);
        }
        return result;
    }
    
    public int hammingWeight2(int n) {
        int result = 0;
        while (n != 0){
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
