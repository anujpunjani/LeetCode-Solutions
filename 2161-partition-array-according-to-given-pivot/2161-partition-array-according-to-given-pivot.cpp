class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> ans(nums.size());
        int index = 0;
        
        for(int i = 0; i < nums.size(); i++)
            if(nums[i] < pivot)
                ans[index++] = nums[i];
        
        for(int i = 0; i < nums.size(); i++)
            if(nums[i] == pivot)
                ans[index++] = nums[i];
        
        for(int i = 0; i < nums.size(); i++)
            if(nums[i] > pivot)
                ans[index++] = nums[i];
        
        return ans;
    }
};