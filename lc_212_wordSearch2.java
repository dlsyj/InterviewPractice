package leetcode;
/* Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.


 * Method: Trie + DFS
 */
import java.util.*;
public class lc_212_wordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        char c = board[i][j];
        if(c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if(p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }
    
        board[i][j] = '#';  // replace current char
        dfs(board, i - 1, j ,p, res); 
        dfs(board, i, j - 1, p, res);
        dfs(board, i + 1, j, p, res); 
        dfs(board, i, j + 1, p, res); 
        board[i][j] = c;    // change it back
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode p = root;
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
