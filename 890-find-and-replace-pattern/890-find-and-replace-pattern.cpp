class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> ans;
                
        for(int i = 0; i < words.size(); i++) {
            
            if(words[i].size() != pattern.size())
                continue;

            unordered_map<char, char> m;
            unordered_map<char, char> m1;

            bool flag = true;
            for(int j = 0; j < words[i].size(); j++) {
                char ch = words[i][j];
                char p = pattern[j];
                if(m.find(p) == m.end())
                    m[p] = ch;
                
                if(m1.find(ch) == m1.end())
                    m1[ch] = p;
                
                if(m[p] != ch || m1[ch] != p) {
                    flag = false;
                    break;
                }
                
            }
            
            
            if(flag)
                ans.push_back(words[i]);
            
        }
        
        return ans;
    }
};