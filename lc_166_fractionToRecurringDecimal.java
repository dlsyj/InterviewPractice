package leetcode;
/* Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 * Method: hashmap 
 */
import java.util.*;
public class lc_166_fractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        // handle sign, corner case
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        sb.append(sign);
        // cast to long to avoid boundary
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        
        long remainder = num % den;
        if (remainder == 0){
            return sb.toString();
        }else{
            sb.append(".");
        }
        HashMap<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remainder)){
            map.put(remainder, sb.length());
            sb.append(10 * remainder / den);    // it may be "0"
            remainder = 10 * remainder % den;
        }
        int index = map.get(remainder);
        sb.insert(index, "(");
        sb.append(")");
        return sb.toString().replace("(0)","");     // remove (0)
    }
}
