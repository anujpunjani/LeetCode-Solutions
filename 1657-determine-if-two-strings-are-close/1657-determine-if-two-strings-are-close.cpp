class Solution {
public:
    
    bool closeStrings(string word1, string word2) {
        if(word1.size() != word2.size()) return false;
        
        vector<int> map1(26, 0);
        vector<int> map2(26, 0);
        
        for(char c : word1)
            map1[c - 'a']++;
        
        for(char c : word2)
            if(map1[c - 'a'] == 0) return false;
            else map2[c - 'a']++;
        
        sort(map1.begin(), map1.end());
        sort(map2.begin(), map2.end());
        
        return map1 == map2? true : false;
    }
};