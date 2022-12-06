class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size() - 1, min_val = INT_MAX;
        
        while(low <= high) {
            if(nums[low] <= nums[high])
                return min(min_val, nums[low]);
            
            int mid = low + (high - low)/2;
            
            if(nums[low] <= nums[mid]) {
                min_val = min(min_val, nums[low]);
                low = mid + 1;
            } else {
                min_val = min(min_val, nums[mid]);
                high = mid - 1;
            }
        }
        
        return min_val;
    }
};