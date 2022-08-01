class Solution {
    
    int pathsCount(int m, int n, int r, int c, int[][] dp) {
        
        if(r > m || c > n) return 0;
        
        if(r == m && c == n) {
            return 1;
        }
        
        if(dp[r][c] != -1) return dp[r][c];
        
        int rightStep = pathsCount(m, n, r + 1, c, dp);
        int downStep = pathsCount(m, n, r, c + 1, dp);
    
        dp[r][c] = rightStep + downStep;
        
        return rightStep + downStep;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        
        return pathsCount(m - 1, n - 1, 0, 0, dp);
    }
}