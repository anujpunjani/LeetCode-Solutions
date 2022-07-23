class Solution {
public:

    void merge(int left, int mid, int right, vector<pair<int, int>> &nums, vector<int> &count) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        vector<pair<int, int>> sorted_nums(right - left + 1);
        while(i <= mid && j <= right) {
            if(nums[i].first <= nums[j].first) {
                sorted_nums[k++] = nums[j++];
            } else {
                count[nums[i].second] += right - j + 1;                
                sorted_nums[k++] = nums[i++];
            }
        }
        while(i <= mid)
            sorted_nums[k++] = nums[i++];
        
        while(j <= right)
            sorted_nums[k++] = nums[j++];

        for(int v = left; v <= right; v++)
            nums[v] = sorted_nums[v - left];
    }
    
    void mergesort(int left, int right, vector<pair<int, int>> &nums, vector<int> &count) {
        if(left >= right) return;
        
        int mid = left + (right - left)/2;
        mergesort(left, mid, nums, count);
        mergesort(mid + 1, right, nums, count);
        merge(left, mid, right, nums, count);
    }
    
    vector<int> countSmaller(vector<int>& nums) {
        vector<pair<int, int>> also_nums;
        
        for(int i = 0; i < nums.size(); i++)
            also_nums.push_back({nums[i], i});
        
        vector<int> count(nums.size(), 0);
        mergesort(0, nums.size()-1, also_nums, count);
        return count;
    }
};