package leetcode;
/* Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example, Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * 
 */
public class lc_079_wordSearch {
	public boolean exist(char[][] board, String word) {
        // DFS
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (find(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, int i, int j, String word, int index){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        board[i][j] = '*';  // temporarily replace
        boolean result = find(board, i+1, j, word, index+1) || find(board, i-1, j, word, index+1) || find(board, i, j+1, word, index+1) || find(board, i, j-1, word, index+1);
        board[i][j] = word.charAt(index);   // Notice to turn back
        return result;
    }
}
