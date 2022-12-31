class Solution {
    int ans = 0;
    
    void uniquePathsIII(int r, int c, int[][] grid) {
        
        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == -1 || grid[r][c] == 3)
            return;
        
        if(grid[r][c] == 2) {
            for(int i = 0; i < grid.length; i++)
                for(int j = 0; j < grid[0].length; j++)
                    if(grid[i][j] == 0) return;
            ans++;
            return;
        }
        
        int temp = grid[r][c];
        grid[r][c] = 3;
        uniquePathsIII(r + 1, c, grid);
        uniquePathsIII(r - 1, c, grid);
        uniquePathsIII(r, c + 1, grid);
        uniquePathsIII(r, c - 1, grid);
        grid[r][c] = temp;
    }
    
    public int uniquePathsIII(int[][] grid) {
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1) { uniquePathsIII(i, j, grid); break; }
        
        return ans;
    }
}