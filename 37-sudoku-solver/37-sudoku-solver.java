class Solution {
    
    private boolean check(char[][] board, char n, int x, int y) {

        for(int i = 0; i < 9; i++) {
            
            if(board[x][i] == n) return false;

            if(board[i][y] == n) return false;

            if(board[3 *(x/3) + i/3][3 * (y/3) + i%3] == n) return false;
        }
        
        return true;
    } 
    
    
    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) 
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++)
                        if(check(board, k, i, j)) {
                            board[i][j] = k;
                            if(solve(board))
                                return true;
                            board[i][j] = '.';
                        }    
                    return false;
                }

        return true;
    }
    
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
}