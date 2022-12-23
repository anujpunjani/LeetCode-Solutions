class Solution {
public:
    
    int maxProfit(int idx, int allowed_to_buy, vector<int> &prices, vector<vector<int>> &dp) {
        if(idx >= prices.size()) return 0;
        if(dp[idx][allowed_to_buy] != -1) return dp[idx][allowed_to_buy];
        
        if(allowed_to_buy == 1) {
            return dp[idx][allowed_to_buy] = max(-prices[idx] + maxProfit(idx + 1, 0, prices, dp), 
                                                0 + maxProfit(idx + 1, 1, prices, dp));
        }
        
        return dp[idx][allowed_to_buy] = max(prices[idx] + maxProfit(idx + 2, 1, prices, dp),
                                            0 + maxProfit(idx + 1, 0, prices, dp));
    }
    
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2, -1));
        return maxProfit(0, 1, prices, dp);
    }
};