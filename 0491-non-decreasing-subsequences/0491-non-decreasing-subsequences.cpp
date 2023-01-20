class Solution {
public:
    
    void fillSubsequences(int idx, vector<int>& nums, vector<int> fill, set<vector<int>> &ans) {
        
        if(idx >= nums.size()) {
            if(fill.size() > 1)
                ans.insert(fill);
            return;
        }
        
        fillSubsequences(idx + 1, nums, fill, ans);
        
        if(fill.empty() || fill.back() <= nums[idx]) {
            fill.push_back(nums[idx]);
            fillSubsequences(idx + 1, nums, fill, ans);
        }
    }
    
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        set<vector<int>> ans;
        fillSubsequences(0, nums, vector<int>(), ans);
        return vector<vector<int>>(ans.begin(), ans.end());
    }
};