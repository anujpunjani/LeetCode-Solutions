class Solution {
public:
    
    bool exist(int r, int c, int idx, vector<vector<char>> &board, string word) {
        
        if(idx == word.size()) return true;
        
        if(r < 0 || c < 0 || r == board.size() || c == board[0].size() || board[r][c] != word[idx] || board[r][c] == '0') return false;   
        
        char temp = board[r][c];
        board[r][c] = '0';
        
        bool right = exist(r + 1, c, idx + 1, board, word);
        bool left = exist(r - 1, c, idx + 1, board, word);
        bool bottom = exist(r, c + 1, idx + 1, board, word);
        bool top = exist(r, c - 1, idx + 1, board, word);
        
        board[r][c] = temp;
        
        return right || left || top || bottom;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        for(int i = 0; i < board.size(); i++)
            for(int j = 0; j < board[0].size(); j++)
                if(exist(i, j, 0, board, word) == true) return true;

        return false;
    }
};