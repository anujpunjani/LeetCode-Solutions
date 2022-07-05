class Solution {
    int count = 0;
    void dfs(int[][] grid, int sr, int sc) {
        
        if(sr < 0 || sc < 0 || sr > grid.length-1 || sc > grid[0].length-1 || grid[sr][sc] == 0)
            return;
        
        grid[sr][sc] = 0;
        count++;
        
        dfs(grid, sr + 1, sc);
        dfs(grid, sr - 1, sc);
        dfs(grid, sr, sc + 1);
        dfs(grid, sr, sc - 1);

    }
    
    public int numEnclaves(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++)
            if(grid[i][0] == 1)
                dfs(grid, i, 0);
        
        for(int i = 0; i < grid.length; i++)
            if(grid[i][grid[0].length-1] == 1)
                dfs(grid, i, grid[0].length-1);
        
        for(int i = 0; i < grid[0].length; i++)
            if(grid[0][i] == 1)
                dfs(grid, 0, i);
        
        for(int i = 0; i < grid[0].length; i++)
            if(grid[grid.length-1][i] == 1)
                dfs(grid, grid.length-1, i);
                
        int enclaves = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    enclaves += count;
                    
                }
            }
        }
        
        return enclaves;
    }
}