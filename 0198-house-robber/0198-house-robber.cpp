class Solution {
    
    private int rob(int idx, int[] nums, int[] dp) {
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        
        int take = nums[idx] + rob(idx + 2, nums, dp);
        int nottake = rob(idx + 1, nums, dp);
        
        return dp[idx] = Math.max(take, nottake);
    }
    
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(0, nums, dp);
    }
}