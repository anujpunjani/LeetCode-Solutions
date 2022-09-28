class Solution {
    
    private int minPathSum(int sr, int sc, int[][] grid, int[][] dp) {
        
        if(sr < 0 || sc < 0 || sr == grid.length || sc == grid[0].length)
            return Integer.MAX_VALUE;
        
        if(sr == grid.length - 1 && sc == grid[0].length - 1)
            return grid[sr][sc];
        
        if(dp[sr][sc] != 0) return dp[sr][sc];
        
        int right = minPathSum(sr, sc + 1, grid, dp);
        int down = minPathSum(sr + 1, sc, grid, dp);
        
        return dp[sr][sc] = grid[sr][sc] + Math.min(right, down);
    }
    
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return minPathSum(0, 0, grid, dp);
    }
}