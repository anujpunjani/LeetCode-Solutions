class Solution {
public:
    vector<vector<int>> ans;
    void combinationSum(int idx, vector<int>& candidates, int target, vector<int> csum) {
        
        if(idx == candidates.size()) {
            if(target == 0) ans.push_back(csum);
            return;
        }
        
        if(candidates[idx] <= target) {
            csum.push_back(candidates[idx]);
            combinationSum(idx, candidates, target - candidates[idx], csum);
            csum.pop_back();            
        }
        combinationSum(idx + 1, candidates, target, csum);
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        combinationSum(0, candidates, target, vector<int>());
        return ans;
    }
};