package leetcode;
/* Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
 * 
 */
public class lc_423_reconstructOriginalDigitsFromEnglish {
	public String originalDigits(String s) {
        int[] arr = new int[10];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length(); i ++){
            if(sArr[i] == 'z'){
                arr[0] += 1;
            }
            if(sArr[i] == 'w'){
                arr[2] += 1;
            }
            if(sArr[i] == 'u'){
                arr[4] += 1;
            }
            if(sArr[i] == 'x'){
                arr[6] += 1;
            }
            if(sArr[i] == 'g'){
                arr[8] += 1;
            }
            if(sArr[i] == 'o'){
                arr[1] += 1;
            }
            if(sArr[i] == 'h'){
                arr[3] += 1;
            }
            if(sArr[i] == 'f'){
                arr[5] += 1;
            }
            if(sArr[i] == 's'){
                arr[7] += 1;
            }
            if(sArr[i] == 'i'){
                arr[9] += 1;
            }
        }
        arr[3] -= arr[8];
        arr[5] -= arr[4];
        arr[7] -= arr[6];
        arr[1] = arr[1] - arr[0] - arr[2] - arr[4];
        arr[9] = arr[9] - arr[5] - arr[6] - arr[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i ++){
            while(arr[i]-- > 0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
