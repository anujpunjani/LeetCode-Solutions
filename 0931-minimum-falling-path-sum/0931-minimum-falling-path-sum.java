class Solution {
    
    private int minFallingPathSum(int r, int c, int[][] matrix,int[][] dp) {
        
        if(c < 0 || c >= matrix[0].length) return Integer.MAX_VALUE;
        
        if(r == matrix.length - 1) return matrix[r][c];
        
        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c];
        
        int left = minFallingPathSum(r + 1, c - 1, matrix, dp);
        int down = minFallingPathSum(r + 1, c, matrix, dp);
        int right = minFallingPathSum(r + 1, c + 1, matrix, dp);
        
        return dp[r][c] = Math.min(left, Math.min(down, right)) + matrix[r][c];
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        int dp[][] = new int[n][m];
        
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < m; i++)
            ans = Math.min(ans, minFallingPathSum(0, i, matrix, dp));
        
        return ans;
    }
}