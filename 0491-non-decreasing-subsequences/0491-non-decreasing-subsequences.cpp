class Solution {
public:
    
    void fillSubsequences(int idx, vector<int>& nums, vector<int> fill, set<vector<int>> &ans) {
        
        if(idx >= nums.size()) {
            if(fill.size() > 1)
                ans.insert(vector<int>(fill));
            return;
        }
        
        fillSubsequences(idx + 1, nums, fill, ans);
        
        if(fill.size() == 0 || fill[fill.size() - 1] <= nums[idx]) {
            fill.push_back(nums[idx]);
            fillSubsequences(idx + 1, nums, fill, ans);
        }
    }
    
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        set<vector<int>> ans;
        vector<int> fill;
        fillSubsequences(0, nums, fill, ans);
        
        return vector<vector<int>>(ans.begin(), ans.end());
    }
};