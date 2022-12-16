class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;
        
        if(nums.size() == 1) return 0;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(mid == 0)
                return nums[0] > nums[1]? 0 : 1;
            if(mid == nums.size() - 1)
                return nums[mid] > nums[mid - 1]? mid : mid - 1;
            
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            
            if(nums[mid + 1] > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
};