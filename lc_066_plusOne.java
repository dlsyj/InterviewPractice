package leetcode;
/* Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list
 * Method: scan from right to left, early return 
 */
public class lc_066_plusOne {
	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i --){
            if (digits[i] < 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
