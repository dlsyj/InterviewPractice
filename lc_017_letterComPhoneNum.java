package leetcode;
/*Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * Input:Digit string "23". Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Ask: Although the above answer is in lexicographical order, your answer could be in any order you want.
 
 * 
 * Method: method combine is to add new letters to old list, using 2 for-loop.
for example:

gave digits = "23"

i=0 -> result=combine("abc", [""]) ---> [a,b,c];

i=1 -> result=combine("def", [a,b,c]) ---> [ad,bd,cd, ae,be,ce, af,bf,cf];
 */

import java.util.*;
public class lc_017_letterComPhoneNum {
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(digits, result, "", map, 0);
        return result;
    }
    
    public void helper(String digits, List<String> result, String curr, String[] map, int index){
        if (index == digits.length()){
            result.add(curr);
            return;
        }
        String candidates = map[digits.charAt(index) - '0'];
        for (int i = 0; i < candidates.length(); i ++){
            curr += candidates.charAt(i);
            helper(digits, result, curr, map, index + 1);
            curr = curr.substring(0,curr.length() - 1);
        }
    }
}
