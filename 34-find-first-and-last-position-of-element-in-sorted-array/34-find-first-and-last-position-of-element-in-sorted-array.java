class Solution {
    int lower_bound(int[] nums, int target) {
        int ans = -1;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) {
                ans = mid;
                r = mid - 1;
            } else if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        
        return ans;
    }
    
    int upper_bound(int[] nums, int target) {
        int ans = -1;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) {
                ans = mid;
                l = mid + 1;
            } else if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        
        return ans;
    }
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{lower_bound(nums, target), upper_bound(nums, target)};
    }
}