package leetcode;
/* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	
	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.
	
	For the purpose of this problem, we define empty string as valid palindrome.
 * Method: two pointers
 */
public class lc_125_validPalindrome {
	public boolean isPalindrome(String s) {
        if (s.isEmpty()){	// attention
            return true;
        }
        int head = 0, tail = s.length()-1;
        while(head <= tail){
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if (!Character.isLetterOrDigit(headChar)){
                head++;
            }else if (!Character.isLetterOrDigit(tailChar)){
                tail--;
            }else{
                if (Character.toLowerCase(headChar) != Character.toLowerCase(tailChar)){
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
