class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        unordered_map<char, vector<int>> map;
        
        for(int i = 0; i < s.size(); i++)
            map[s[i]].push_back(i);
        
        int ans = 0;
        for(auto word : words) {
            
            int low = -1;
            int i = 0;
            for(i; i < word.size(); i++) {
                if(map.find(word[i]) == map.end())
                    break;
                int pos = upper_bound(map[word[i]].begin(), map[word[i]].end(), low) - map[word[i]].begin();
                if(pos == map[word[i]].size())
                    break;
                low = map[word[i]][pos];
            }
            
            if(i == word.size())
                ans++;
        }
        return ans;
    }
};