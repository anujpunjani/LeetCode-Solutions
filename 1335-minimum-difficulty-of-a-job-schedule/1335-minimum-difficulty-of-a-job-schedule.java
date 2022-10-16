class Solution {
    
    private int dfs(int idx, int[] jobDifficulty, int d, int[][] dp) {
        if(d == 1) {
            int max = Integer.MIN_VALUE;
            while(idx < jobDifficulty.length)
                max = Math.max(max, jobDifficulty[idx++]);
            return max;
        }
        
        if(dp[d][idx] != -1) return dp[d][idx];
        
        int leftMax = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        
        for(int i = idx; i <= jobDifficulty.length - d; i++) {
            leftMax = Math.max(leftMax, jobDifficulty[i]);
            int rightMax = dfs(i + 1, jobDifficulty, d - 1, dp);
            ans = Math.min(ans, leftMax + rightMax);
        }
        
        return dp[d][idx] = ans;
    }
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;
        
        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        for(int[] e : dp) Arrays.fill(e, -1);
        
        return dfs(0, jobDifficulty, d, dp);
    }
}