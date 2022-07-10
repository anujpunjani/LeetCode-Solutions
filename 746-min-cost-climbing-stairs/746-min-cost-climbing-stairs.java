class Solution {
    
    private int recursion(int[] cost, int idx) {
        
        if(idx >= cost.length)
            return 0;
        
        int oneStep = recursion(cost, idx + 1);
        int twoStep = recursion(cost, idx + 2);
        
        return Math.min(oneStep, twoStep) + cost[idx];
    }
    
    private int memo(int[] cost, int idx, int[] dp) {
        
        if(idx >= cost.length)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int oneStep = memo(cost, idx + 1, dp);
        int twoStep = memo(cost, idx + 2, dp);
        
        return dp[idx] = Math.min(oneStep, twoStep) + cost[idx];
    }
    
    private int tabularization(int[] cost) {
        
        int[] dp = new int[cost.length];
        dp[dp.length - 1] = cost[cost.length - 1];
        dp[dp.length - 2] = cost[cost.length - 2];
        for(int i = dp.length - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        
        return Math.min(dp[0], dp[1]);
    } 
    
    public int minCostClimbingStairs(int[] cost) {
        // int recursion = Math.min(recursion(cost, 0), recursion(cost, 1));
        
        // int[] dp = new int[cost.length];
        // Arrays.fill(dp, -1);
        // memo(cost, 0, dp);
        // int memo = Math.min(dp[0], dp[1]);
        
        int tabularization = tabularization(cost);
        return tabularization;
    }
}