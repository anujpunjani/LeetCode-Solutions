class Solution {
public:
    
    bool ans = false;
    
    void exist(int r, int c, int idx, vector<vector<char>> &board, string word) {
        
        if(idx == word.size()) {
            ans = true;
            return;
        }
        
        if(r < 0 || c < 0 || r == board.size() || c == board[0].size() || board[r][c] != word[idx] || board[r][c] == '0') return;
        
        if(ans == true) return;
        
        char temp = board[r][c];
        board[r][c] = '0';
        exist(r + 1, c, idx + 1, board, word);
        exist(r - 1, c, idx + 1, board, word);
        exist(r, c + 1, idx + 1, board, word);
        exist(r, c - 1, idx + 1, board, word);
        board[r][c] = temp;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        for(int i = 0; i < board.size(); i++)
            for(int j = 0; j < board[0].size(); j++)
                if(board[i][j] == word[0] && ans == false)
                    exist(i, j, 0, board, word);

        return ans;
    }
};