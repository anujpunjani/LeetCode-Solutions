class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        if(s1.size() > s2.size()) return false;
        
        vector<int> freq(26, 0);
        for(char c : s1) freq[c - 'a']++;
        
        int i = 0;
        
        while(i <= s2.size() - s1.size()) {
            string sub = s2.substr(i, s1.size());
            vector<int> temp(26, 0);
            for(char c : sub) temp[c - 'a']++;
            if(temp == freq) return true;
            i++;
        }
        
        return false;
    }
};