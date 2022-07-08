class Solution {
    
    private void dfs(int sr, int sc, int[][] heights, boolean[][] vis) {
        
        if(vis[sr][sc] == true)
            return;
        
        vis[sr][sc] = true;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for(int[] d : dir) {
            
            int nr = sr + d[0];
            int nc = sc + d[1];
            
            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length)
                continue;
            
            if(heights[nr][nc] >= heights[sr][sc])
                dfs(nr, nc, heights, vis);
        }
        
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        for(int i = 0; i < m; i++) dfs(0, i, heights, pacific);
        for(int i = 0; i < n; i++) dfs(i, 0, heights, pacific);
        
        boolean[][] atlantic = new boolean[n][m];
        for(int i = 0; i < n; i++) dfs(i, m-1, heights, atlantic);
        for(int i = 0; i < m; i++) dfs(n-1, i, heights, atlantic);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
        
        return ans;
    }
}