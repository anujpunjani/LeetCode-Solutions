class Solution {
public:
    
    void findCombinations(int idx, vector<int> nums, int target, vector<int> sum, vector<vector<int>> &ans) {
        
        if(target == 0) {
            ans.push_back(sum);
            return;
        }
        
        
        for(int i = idx; i < nums.size(); i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            
            sum.push_back(nums[i]);
            findCombinations(i + 1, nums, target - nums[i], sum, ans);
            sum.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        sort(candidates.begin(), candidates.end());
        findCombinations(0, candidates, target, vector<int>(), ans);
        return ans;
    }
};