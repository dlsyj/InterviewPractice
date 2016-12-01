package leetcode;
/* The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * 
 */
public class lc_038_countAndSay {
	public String countAndSay(int n) {
        String result = "1";
        while (n-- > 1){    // Notice: 自减至>1
            StringBuilder sb = new StringBuilder();
            char[] oldChars = result.toCharArray();
            
            for (int i = 0; i < oldChars.length; i ++){
                int count = 1;
                while ((i+1) < oldChars.length && oldChars[i] == oldChars[i + 1]){    // Notice: i是为了方便最后一位的
                    count ++;
                    i ++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            result = sb.toString();
        }
        return result;
    }
}
