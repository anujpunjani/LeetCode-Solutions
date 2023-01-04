class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int, int> m;
        
        for(int task : tasks) m[task]++;

        
        int ans = 0;
        
        for(auto entry : m) {
            int val = entry.second;
            
            if(val == 1) return -1;

            
            ans += min(min(val % 3 == 0? val / 3 : INT_MAX, val % 2 == 0? val / 2 : INT_MAX), min(val / 3, val / 2) + 1);
        }
        
        return ans;
    }
};