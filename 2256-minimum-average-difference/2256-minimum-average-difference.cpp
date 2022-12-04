class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        if(nums.size() == 1) return 0;
        
        vector<long long> to_left(nums.size());
        vector<long long> to_right(nums.size());
        
        to_left[nums.size() - 1] = nums[nums.size() - 1];
        to_right[0] = nums[0];
        
        for(int i = 1, j = nums.size() - 2; j >= 0; i++, j--) {
            to_left[j] = nums[j] + to_left[j + 1];
            to_right[i] = nums[i] + to_right[i - 1];
        }
        
        int min_index = -1;
        long long min_diff = INT_MAX;
        
        for(int i = 0; i < nums.size(); i++) {
            
            long long left_sum = to_right[i];
            long long right_sum = i + 1 >= nums.size()? 0 : to_left[i + 1];
            
            long long left = round(left_sum/(i+1));
            long long right = (nums.size() - i - 1) != 0? round(right_sum/(nums.size() - i - 1)) : 0;
            
            long long temp = abs(left - right);
  
            if(temp < min_diff) {
                min_index = i;
                min_diff = temp;
            }
        }
        
        return min_index;
    }
};