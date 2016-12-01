package leetcode;
/* Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output: 
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output: 
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
 * Method:
 *
sub-problem: if there's a new line which is starting with certain index in sentence, what is the starting index of next line (nextIndex[]). BTW, we compute how many times the pointer in current line passes over the last index (times[]).
relation : ans += times[i], i = nextIndex[i], for _ in 0..<row. where i indicates what is the first word in the current line.
        
 */
public class lc_418_sentenceScreenFitting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextLine = new int[sentence.length];
        int[] wordTimes = new int[sentence.length];
        for (int i = 0; i < sentence.length; i ++){
            int currWord = i;
            int len = 0;
            int time = 0;
            while(len + sentence[currWord].length() <= cols){   // current word can be accommodated
                len += sentence[currWord ++].length() + 1;
                if (currWord == sentence.length){               // reach the last word of the sentence
                    time ++;
                    currWord = 0;
                }
            }
            nextLine[i] = currWord;
            wordTimes[i] = time;
        }
        int result = 0;
        int wordIndex = 0;
        for (int i = 0; i < rows; i ++){
            result += wordTimes[wordIndex];
            wordIndex = nextLine[wordIndex];
        }
        return result;
    }
}
