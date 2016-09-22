public class Solution {
    public boolean exist(char[][] board, String word) {
        // DFS
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                if (board[i][j] == word.charAt(0)){
                    boolean found = DFShelper(board, word, i, j, 0);
                    if (found){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean DFShelper(char[][] board, String word, int i , int j, int index){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        boolean found = false;
        if (board[i][j] == word.charAt(index)){
            board[i][j] = '*';
            found = DFShelper(board, word, i - 1, j, index + 1) || DFShelper(board, word, i + 1, j, index + 1) || DFShelper(board, word, i, j - 1, index + 1) || DFShelper(board, word, i, j + 1, index + 1);
            board[i][j] = word.charAt(index);
        }
        return found;
    }
}