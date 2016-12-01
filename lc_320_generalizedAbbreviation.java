package leetcode;
/* Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 * Method: for each char, we can (1)abbreviate it and increase count (2)keep raw format and reset count 
 */
import java.util.*;
public class lc_320_generalizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        helper(word, result, 0, "", 0);
        return result;
    }
    
    public void helper(String word, List<String> result, int index, String curr, int count){
        if (index == word.length()){
            if(count > 0){
                curr += String.valueOf(count);
            }
            result.add(curr);
        }else{
            helper(word, result, index + 1, curr, count + 1); // abbreviate current char
            helper(word, result, index + 1, curr + (count == 0 ? "" : String.valueOf(count)) + word.charAt(index), 0);
        }
    }
}
