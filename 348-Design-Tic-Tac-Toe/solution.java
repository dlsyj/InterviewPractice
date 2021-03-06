public class TicTacToe {
private int[] rows;
private int[] columns;
private int diagonal;
private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        columns = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int who = player == 1 ? 1 : -1;
        int n = rows.length;
        rows[row] += who;
        columns[col] += who;
        if (row - col == 0){
            diagonal += who;
        }
        if (row + col == n - 1){
            antiDiagonal += who;
        }
        if (Math.abs(rows[row]) == n || Math.abs(columns[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */