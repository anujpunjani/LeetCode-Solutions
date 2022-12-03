class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> m;
        unordered_map<int, vector<char>> reversem;
        
        for(int i = 0; i < s.size(); i++)
            m[s[i]]++;
        
        for(auto it: m) {
            reversem[it.second].push_back(it.first);
        }
        
        string ans = "";
        
        for(int i = s.size(); i >= 0; i--) {
            
            for(auto c : reversem[i]) {
                int temp = i;
                while(temp --> 0)
                    ans += c;
            }
            
        }
        
        return ans;
    }
};