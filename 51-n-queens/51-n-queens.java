class Solution {
    
    private boolean check(boolean[][] board, int x, int y) {
        
        // upward
        for(int i = x; i >= 0; i--)
            if(board[i][y] == true) return false;
        
        // left diagnol
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == true) return false;
        
        // right diagnol
        for(int i = x, j = y; i >= 0 && j < board.length; i--, j++)
            if(board[i][j] == true) return false;
        
        return true;
    }
    
    private void putNQueens(int row, boolean[][] board, List<List<String>> ans) {
        
        if(row == board.length) {
            List<String> temp = new ArrayList();
            for(int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder("");
                for(int j = 0; j < board.length; j++)
                    if(board[i][j] == true) sb.append("Q");
                    else sb.append(".");
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }
        
        for(int col = 0; col < board.length; col++) {
            if(check(board, row, col) == true) {
                board[row][col] = true;
                putNQueens(row + 1, board, ans);
                board[row][col] = false;
            }
        }
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        putNQueens(0, board, ans);
        return ans;
    }
}