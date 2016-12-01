package leetcode;
/* Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 * 
 */
import java.util.*;
public class lc_282_expressionAddOperators {
	/*
								    123
								 /    |    \
		第一个数                 1    12   123
							  /  \     \
		第二个数              2   23     3
						   /
		第三个数           3
*/
	public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        dfsHelper(num, target, result, 0, 0, "");
        return result;
    }
    
    public void dfsHelper(String num, int target, List<String> result, long currSum, long prevSum, String temp){
        // one solution found
        if (num.length() == 0 && currSum == target){
            result.add(temp);
            return;
        }
        for (int i = 1; i <= num.length(); i ++){
            // extract first number
            String first = num.substring(0,i);
            // handle leading 0
            if (first.length() > 1 && first.charAt(0) == '0'){
                return;
            }
            long value = Long.parseLong(first);
            // extract second number
            String second = num.substring(i);
            if (!temp.equals("")){
                // plus
                dfsHelper(second, target, result, currSum + value, currSum, temp + "+"+ first);
                // minus
                dfsHelper(second, target, result, currSum - value, currSum, temp + "-"+ first);
                // multiply
                dfsHelper(second, target, result, (currSum - prevSum) * value + prevSum, prevSum, temp + "*" + first);
            }else{
                dfsHelper(second, target, result, currSum + value, currSum, first);
            }
        }
    }
}
