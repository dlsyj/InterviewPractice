package leetcode;
/* Related to question Excel Sheet Column Title
	Given a column title as appear in an Excel sheet, return its corresponding column number.
	
	For example:
	
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
 * 
 */
public class lc_171_excelSheetColumnNumber {
	public int titleToNumber(String s) {
        int result = 0;
        if (s == null || s.length() == 0){
            return result;
        }
        
        for ( int i = 0; i < s.length(); i ++){
            int num = s.charAt(i) - 'A' + 1;
            result = num + result * 26;
        }
        return result;
    }
}
