package leetcode;
/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, 
 * such that:
	Only one letter can be changed at a time
	Each intermediate word must exist in the word list
	For example,
	
	Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
 * 
 * Method: BFS solution with queue and HashSet
 */
import java.util.*;
public class lc_127_wordLadder {
	// BFS solution with queue and HashSet
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // Validate input
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || beginWord.length() != endWord.length()){
            return 0;
        }
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        int level = 1;
        int currNum = 1;    // # of remaining elements in current level
        int nextNum = 0;    // # of remaining elements in next level
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()){
            String curr = queue.poll();
            currNum --;
            char[] charCurr = curr.toCharArray();
            for (int i = 0; i < curr.length(); i ++){
                for (char c = 'a'; c <= 'z'; c ++){
                    charCurr[i] = c;
                    String temp = new String(charCurr);
                    if (temp.equals(endWord)){
                        return level+1;
                    }
                    if (wordList.contains(temp) && !visited.contains(temp)){
                        nextNum ++;
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
                charCurr[i] = curr.charAt(i);   // Don't forget to change it back
            }
            if (currNum == 0){
                currNum = nextNum;
                nextNum = 0;
                level ++;
            }
        }
        return 0;
    }
}
