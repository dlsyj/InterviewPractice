package leetcode;
/* Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * Method: Trie + Backtracking
 */
import java.util.*;
public class lc_425_wordSquares {
TrieNode root = new TrieNode();
    
    public class TrieNode{
        TrieNode[] children = new TrieNode[26];
        List<String> prefixWords = new ArrayList<String>();
    }
    
    public void buildTree(String[] words){
        for (String word : words){
            TrieNode node = root;
            for (char c : word.toCharArray()){
                node.prefixWords.add(word);
                int pos = c - 'a';
                if (node.children[pos] == null){
                    node.children[pos] = new TrieNode();
                }
                node = node.children[pos];
            }
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0){
            return result;
        }
        buildTree(words);
        int n = words[0].length();
        findSquares(result, n, new ArrayList<String>());
        return result;
    }
    
    public void findSquares(List<List<String>> result, int n, List<String> curr){
        if (curr.size() == n){      // find the last word
            result.add(new ArrayList<String>(curr));
            return;
        }
        int index = curr.size();    // find the index of character to search
        StringBuilder temp = new StringBuilder();
        for (String each : curr){   // append each char in curr
            temp.append(each.charAt(index));
        }
        String currPre = temp.toString();
        TrieNode node = root;
        for (int i = 0; i < currPre.length(); i ++){
            if (node.children[currPre.charAt(i) - 'a'] != null){
                node = node.children[currPre.charAt(i) - 'a'];
            }else{
                node = null;
                break;
            }
        }
        if (node != null){
            for (String next : node.prefixWords){
                curr.add(next);
                findSquares(result, n, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
