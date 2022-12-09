class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        int ans = 0;
        vector<int> freq(60, 0);
        
        for(int i = 0 ; i < time.size(); i++) {
            
            int val = time[i]%60;
            
            if(val == 0)
                ans += freq[val];
            else
                ans += freq[60 - val];
            
            freq[val]++;
        }
        
        return ans;
    }
};