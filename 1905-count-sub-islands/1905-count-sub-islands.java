class Solution {
    
    boolean check = true;
    private void dfs(int sr, int sc, int[][] grid1, int[][] grid2) {
        
        if(sr < 0 || sc < 0 || sr > grid1.length-1 || sc > grid1[0].length-1 || grid2[sr][sc] == 0)
            return;
        
        if(grid1[sr][sc] != grid2[sr][sc])
            check = false;

        grid1[sr][sc] = 0;
        grid2[sr][sc] = 0;
        
        dfs(sr + 1, sc, grid1, grid2);
        dfs(sr - 1, sc, grid1, grid2);
        dfs(sr, sc + 1, grid1, grid2);
        dfs(sr, sc - 1, grid1, grid2);
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        
        for(int i = 0; i < grid2.length; i++)
            for(int j = 0; j < grid2[0].length; j++)
                if(grid2[i][j] == 1 && grid1[i][j] == 1) {
                    check = true;
                    dfs(i, j, grid1, grid2);
                    if(check) ans++;
                }
        
        return ans;
    }
}