class Solution {
    
    int count = 0;
    private void dfs(int sr, int sc, int[][] grid) {
        
        if(sr < 0 || sc < 0 || sr > grid.length-1 || sc > grid[0].length-1 || grid[sr][sc] == 0)
            return;
        
        grid[sr][sc] = 0;
        count++;
        
        dfs(sr + 1, sc, grid);
        dfs(sr - 1, sc, grid);
        dfs(sr, sc + 1, grid);
        dfs(sr, sc - 1, grid);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1) {
                    count = 0;
                    dfs(i, j, grid);
                    ans = Math.max(ans, count);
                }
        
        return ans;
    }
}