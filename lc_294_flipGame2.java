package leetcode;
/* You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
 *  Method:The idea is try to replace every "++" in the current string s to "--" and see if the opponent can win or not, if the opponent cannot win, great, we win!

For the time complexity, here is what I thought, let's say the length of the input string s is n, there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."), once we replace one "++", there are at most (n - 2) - 1 ways to do the replacement, it's a little bit like solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., so it's O(n!!), double factorial.

 *One improvement: adding memorization (HashSet) will greatly reduce time complexity. 
 *Although game theory can do much better, I think the following solution is very ideal for an interview.
 *If we use HashMap to memorize both win string & lose string, we can further reduce time from 208ms to 18ms:
 */
import java.util.*;
public class lc_294_flipGame2 {
	public boolean canWin(String s) {
        if (s == null || s.length() < 2){
            return false;
        }
        Map<String, Boolean> winSet = new HashMap<String, Boolean>();
        return canWin(s, winSet);
    }
    
    public boolean canWin(String s, Map<String, Boolean> winSet){
        if (winSet.containsKey(s)){
            return winSet.get(s);
        }
        for (int i = 0; i < s.length() - 1; i ++){
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                String next = s.substring(0,i) + "--" + s.substring(i + 2);
                if (!canWin(next, winSet)){
                    winSet.put(s, true);
                    return true;
                }
            }
        }
        winSet.put(s,false);
        return false;
    }
}
