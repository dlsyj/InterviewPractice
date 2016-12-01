package leetcode;

import java.util.List;

/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * 
 */
import java.util.*;
public class lc_089_grayCode {
	public List<Integer> grayCode(int n){
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < 1<<n; i ++){
			result.add(i ^ (i>>1));
		}
		return result;
	}
	/*
    The purpose of this function is to convert an unsigned
    binary number to reflected binary Gray code.

    The operator >> is shift right. The operator ^ is exclusive or.
*/
	int binaryToGray(int num){
	    return (num >> 1) ^ num;
	}
	// 0^0 = 0, 1^0 = 1, 2^1 = 3, 3^1 = 2
	/*
	    The purpose of this function is to convert a reflected binary
	    Gray code number to a binary number.
	*/
	int grayToBinary(int num){
		int mask;
		for (mask = num >> 1; mask != 0; mask = mask >> 1){
		    num = num ^ mask;
		}
		return num;
	}
}
