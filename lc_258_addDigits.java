package leetcode;
/* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Method: 
 * First you should understand:
	10^k % 9 = 1
	a*10^k % 9 = a % 9 
	Then let's use an example to help explain.
	
	Say a number x = 23456
	
	x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6
	
	2 * 10000 % 9 = 2 % 9
	
	3 * 1000 % 9 = 3 % 9
	
	4 * 100 % 9 = 4 % 9
	
	5 * 10 % 9 = 5 % 9
	
	Then x % 9 = ( 2+ 3 + 4 + 5 + 6) % 9, note that x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6
	
	So we have 23456 % 9 = (2 + 3 + 4 + 5 + 6) % 9
	
	0~9 (10 nums) :      0,1,2,3,4,5,6,7,8,9
	10~18(9 nums):         1,2,3,4,5,6,7,8,9
	19~27(9 nums):         1,2,3,4,5,6,7,8,9
	and so on
 */
public class lc_258_addDigits {
	public int addDigits(int num) {
        return (num != 0 && num % 9 == 0) ? 9 : num % 9;
    }
}
