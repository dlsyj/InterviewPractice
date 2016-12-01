package leetcode;
/* Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * Method:
Observation 1: our highest prioirty is to move the number that is at index 0, with index 1 being 0
    For example, if we have 3004567 and we want to remove 1 digit, we defintely want to remove 3, so that we can
    get rid of the following 2 zeros, ending up with 4567, which will always give us the biggest decrease

Observation 2: if there is no case of observation 1, then we want to remove the biggest number in the first ascenging sequence.
    For example, if we have 234543, we want to remove the 5 first, since after 5 the number starts going down.
    
Observatino 3: if we have to remove more than 1 digit, every digit removal can use the same strategy, i.e we can use greedy algorithm here, aka not dp. 

 */
import java.util.*;
public class lc_402_removeKDigits {
	public String removeKdigits(String num, int k) {
        // convert string to List to make it easier to remove
        List<Character> list = new ArrayList<>();
        for (char c : num.toCharArray()){
            list.add(c);
        }
        // remove k digits
        while (k-- > 0){
            int currLen = list.size();
            // case 1: handle X0XXX
            if (currLen > 1 && list.get(1) == '0'){
                list.remove(0);             // remove first digit
                while (list.size() > 0 && list.get(0) == '0'){
                    list.remove(0);
                }
            }
            // case 2: handle other permutation
            if (currLen == list.size()){    // whether changed in case 1
                for (int j = 0; j < currLen; j ++){
                    if (( j < currLen - 1 && list.get(j) > list.get(j + 1)) || j == currLen - 1){
                        list.remove(j);
                        break;          // only remove one char here
                    }
                }
            }
        }
        // construct output string
        if (list.size() == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
    }
}
