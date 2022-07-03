class Solution {
    
    private void dfs(char[][] grid, int sr, int sc) {
        
        if(sr < 0 || sc < 0 || sr > grid.length -1 || sc > grid[0].length-1 || grid[sr][sc] == '0' || grid[sr][sc] == '2')
            return;
        
        grid[sr][sc] = '2';
        
        dfs(grid, sr + 1, sc);
        dfs(grid, sr, sc + 1);
        dfs(grid, sr - 1, sc);
        dfs(grid, sr, sc - 1);
    }
    
    public int numIslands(char[][] grid) {
        
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            
            for(int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;                    
                }
                
            }
            
        }
        
        return islands;
    }
}