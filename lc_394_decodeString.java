package leetcode;
/* Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * Method: Stack
 */
import java.util.*;
public class lc_394_decodeString {
	public String decodeString(String s) {
        Stack<Integer> number = new Stack<Integer>();
        Stack<String> letter = new Stack<String>();
        if (s == null || s.length() == 0){
            return "";
        }
        int i = 0;
        letter.push("");    // easy to forget
        System.out.println(letter.size());
        while (i < s.length()){
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9'){
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'){   // 此时i+1防止i自动加1后吞掉后一位字母
                    i ++;
                }
                int currNum = Integer.parseInt(s.substring(start, i + 1));
                // System.out.println(currNum);
                number.push(currNum);
            }else if (ch == '['){
                letter.push("");
                // System.out.println(letter.size());
            }else if (ch == ']'){
                String currLetter = letter.pop();
                int currNum = number.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < currNum; j ++){
                    sb.append(currLetter);
                }
                // System.out.println(sb.toString());
                // System.out.println(letter.size());
                letter.push(letter.pop() + sb.toString());
            }else{
                letter.push(letter.pop() + ch);
            }
            i ++;   // easy to forget
        }
        return letter.pop();
    }
}
