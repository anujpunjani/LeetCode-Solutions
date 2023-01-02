class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int ans = 0;
        vector<unordered_map<int, int>> maps(nums.size());
        
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < i; j++) {
                long diff = (long)(nums[j]) - nums[i];
                if(diff <= INT_MIN || diff >= INT_MAX) continue;
                
                int n2 = maps[i][diff];
                int n1 = maps[j][diff];
                ans += n1;
                int freq = n1 + n2 + 1;
                maps[i][diff] = freq;
            }
        }
        
        return ans;
    }
};