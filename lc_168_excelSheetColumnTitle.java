package leetcode;
/* Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
 * 
 */
public class lc_168_excelSheetColumnTitle {
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            n --;       // Attention here, handle 'Z'
            char curr = (char) (n % 26 + 'A');
            sb.insert(0,curr);
            n /= 26;
        }
        return sb.toString();
    }
}
