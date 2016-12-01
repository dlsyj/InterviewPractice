package leetcode;
/*Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it IN-PLACE without allocating extra space?
 * 
 * Method: Reverse all and reverse words one by one
 */
public class lc_186_reverseWordsInAString2 {
	public void reverseWords(char[] s) {
        reverseWords(s,0,s.length-1);
        for (int i = 0, j = 0; i <= s.length; i++){ // 注意等号
            if (i == s.length || s[i] == ' '){      // 注意 i == s.length
                reverseWords(s,j,i-1);
                j = i+1;
            }
        }
    }
    
    public void reverseWords(char[] arr, int left, int right){
        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
    }
}
