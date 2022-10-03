class Solution {
    
    private int numRollsToTarget(int n, int k, int target, int dp[][]) {
        
        if(n < 0 || target < 0) return 0;
        if(n == 0 && target == 0) return 1;
        if(dp[n][target] != -1) return dp[n][target];
        
        int ways = 0;
        for(int i = 1; i <= k; i++) 
            if(i <= target)
                ways = (ways + numRollsToTarget(n - 1, k, target - i, dp)) % (int)(1e9 + 7);
        
        return dp[n][target] = ways;
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];
        for(int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        return numRollsToTarget(n, k, target, dp);
    }
}