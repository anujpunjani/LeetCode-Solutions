class Solution {
public:
    
//     bool canJump(int src, int dest, vector<int> &nums, vector<int> &dp) {
//         if(src == dest) return true;
//         if(src > dest) return false;
//         if(dp[src] != -1) return 1 == dp[src];
        
//         bool temp = false;
        
//         for(int i = 1; i <= nums[src]; i++) {
//             temp = temp || canJump(src + i, dest, nums, dp);
//             if(temp) break;
//         }
        
//         dp[src] = temp? 1 : 0;
//         return temp;
//     }
    
//     bool canJump(vector<int>& nums) {
//         vector<int> dp(nums.size(), -1);
//         return canJump(0, nums.size() - 1, nums, dp);
//     }
    
    bool canJump(vector<int> &nums) {
        
         int boundary = 0;
         for(int i = 0; i <= boundary; i++) {
             
             boundary = max(boundary,i + nums[i]);
          
             if(boundary >= nums.size()-1)
                return true;
         } 
         
        return false;
    }
};