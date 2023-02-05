class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> ans;
        if(p.size() > s.size()) return ans;
        
        unordered_map<char, int> phash;
        unordered_map<char, int> shash;
        int size = p.size();

        for(char ch : p)
            phash[ch]++;
        
        for(int i = 0; i < size; i++) 
            shash[s[i]]++;
        
        if(phash == shash)
            ans.push_back(0);
        
        for(int i = size, j = 0; i < s.size(); i++) {
            
            shash[s[j]]--;
            if(shash[s[j]] == 0) 
                shash.erase(s[j]);
            shash[s[i]]++;
            
            if(phash == shash)
                ans.push_back(i - size + 1);
            j++;
        }
        
        return ans;
    }
};