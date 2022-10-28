class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> amap;
        
        for(string str : strs) {
            string temp = str;
            sort(temp.begin(), temp.end());
            amap[temp].push_back(str);
        }
        
        vector<vector<string>> ans;
        for(auto e : amap)
            ans.push_back(e.second);
        
        return ans;
    }
};