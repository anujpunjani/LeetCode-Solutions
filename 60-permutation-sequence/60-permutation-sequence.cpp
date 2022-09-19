class Solution {
public:
    string getPermutation(int n, int k) {
        string nums = "";
        for(int i = 1; i <= n; i++) nums += to_string(i);
        
        string ans = "";
        k--;
        
        while(nums.size() > 0) {
            
            int fact = 1;
            for(int i = 1; i <= nums.size() - 1; i++) fact *= i;
            
            int q = k / fact;
            int r = k % fact;
            
            ans += nums[q];
            k = r;
            
            string temp = "";
            for(int i = 0; i < nums.size(); i++)
                if(i != q) temp += nums[i];
            
            nums = temp;
        }
        
        return ans;
    }
};