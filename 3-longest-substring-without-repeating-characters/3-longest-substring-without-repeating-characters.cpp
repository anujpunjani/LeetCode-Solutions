class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size() == 0) return 0;

        unordered_map<int, int> m;
            
        int start = 0, ans = 0;
        
        for(int i = 0; i < s.size(); i++) {
            
            int temp = -1;
            if(m.find(s[i]) != m.end()) temp = m[s[i]];
            
            if(temp != -1) {
                start = max(start, temp + 1);
            }
            
            m[s[i]] = i;
            ans = max(ans, i - start + 1);
        }
        
        return ans;
    }
};