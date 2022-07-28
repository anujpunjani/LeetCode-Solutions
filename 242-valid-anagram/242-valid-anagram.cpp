class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        unordered_map<char, int> m;
        for(char a : s)
            m[a]++;
        for(char a : t) {
            m[a]--;
            if(m[a] < 0) return false;
        }
        return true;
    }
};