class Solution {
    
    private boolean check(char[][] board, char n, int x, int y) {
        
        for(int i = 0; i < board.length; i++)
             if(board[x][i] == n) return false;
        
        for(int i = 0; i < board.length; i++)
             if(board[i][y] == n) return false;
        
        x = x%3 == 0? x : x - x%3;
        y = y%3 == 0? y : y - y%3;
        
        for(int i = x; i < x + 3; i++)
            for(int j = y; j < y + 3; j++)
                if(board[i][j] == n) return false;
        
        return true;
    } 
    
    
    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board.length; j++) {
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
            }
        
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
}