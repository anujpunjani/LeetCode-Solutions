class Solution {
    
    private boolean check(char[][] board, char n, int x, int y) {

        for(int i = 0; i < board.length; i++)
             if(i != y && board[x][i] == n) return false;
        
        for(int i = 0; i < board.length; i++)
             if(i != x && board[i][y] == n) return false;
        
        int r = x, c = y;
        
        x = x%3 == 0? x : x - x%3;
        y = y%3 == 0? y : y - y%3;
        for(int i = x; i < x + 3; i++)
            for(int j = y; j < y + 3; j++)
                if(i != r && j != c && board[i][j] == n) return false;
        
        return true;
    } 
    
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') continue;
                if(check(board, board[i][j], i, j) == false) return false;
            }
        }
        
        return true;
    }
}