package leetcode;
/* Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

 * 
 */
public class lc_344_reverseString {
	public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
	public String reverseString2(String s) {
        int left = 0, right = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (left < right){
            char temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            left ++;
            right --;
        }
        return new String(sArr);
    }
}
