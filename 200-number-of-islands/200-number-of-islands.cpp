class Solution {
public:
    void numIslands(int r, int c, vector<vector<char>> &grid) {
        if(r < 0 || c < 0 || r == grid.size() || c == grid[0].size() || grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        
        numIslands(r + 1, c, grid);
        numIslands(r - 1, c, grid);
        numIslands(r, c + 1, grid);
        numIslands(r, c - 1, grid);
    }
    
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for(int i = 0; i < grid.size(); i++)
            for(int j = 0; j < grid[0].size(); j++)
                if(grid[i][j] == '1') {
                    count++;
                    numIslands(i, j, grid);
                }
        
        return count;
    }
};