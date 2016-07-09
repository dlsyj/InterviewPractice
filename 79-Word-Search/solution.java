public class Solution {

    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0) && dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][]board,int i, int j, int index, String word){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) ||visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean aroundFound = dfs(board,i-1,j,index+1,word)||
                     dfs(board,i+1,j,index+1,word)||
                     dfs(board,i,j-1,index+1,word)||
                     dfs(board,i,j+1,index+1,word);
        // Attention here, must change visited[i][j] to false;
        visited[i][j] = false;
        return aroundFound;
    }
}