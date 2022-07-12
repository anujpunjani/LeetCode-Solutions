class Solution {
public:
    int nums[4] = {0};
    int side = 0;
    bool dfs(int idx, vector<int>& matchsticks) {
        
        if(idx == matchsticks.size()) {
            if(nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[3])
                return true;
            
            return false;
        }
        
        for(int i = 0; i < 4; i++) {
            
            if(nums[i] + matchsticks[idx] > side) continue;
            
            nums[i] += matchsticks[idx];
            
            if(dfs(idx + 1, matchsticks))
                return true;
            
            nums[i] -= matchsticks[idx];
        }
        
        return false;
    }
    
    bool makesquare(vector<int>& matchsticks) {
        // dekh kr kara hai
        int perimeter = 0;
        perimeter = accumulate(matchsticks.begin(), matchsticks.end(), perimeter);
        side=perimeter/4;
        
        if(side * 4 != perimeter)
            return false;

        sort(matchsticks.begin(), matchsticks.end(), greater<int>());
        
        return dfs(0, matchsticks);
    }
};