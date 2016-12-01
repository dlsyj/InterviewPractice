package leetcode;
/* Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 * Method: two pointers
 */
public class lc_345_reverseVowelsOfAString {
	static final String vowels = "aeiouAEIOU";
    public String reverseVowels(String s) {
        char[] result = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right){
            while (left < right && vowels.indexOf(result[left]) == -1){
                left ++;
            }
            while (left < right && vowels.indexOf(result[right]) == -1){
                right --;
            }
            char temp = result[left];
            result[left] = result[right];
            result[right] = temp;
            left ++;
            right --;
        }
        return new String(result);
    }
}
