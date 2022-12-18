class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_map<int, int> out;
        
        for(auto match : matches) {
            out[match[1]]++;
            out[match[0]] = out[match[0]];
        }
        
        vector<int> all_win, one_lost;
        
        for(auto e : out)
            if(e.second == 0)
                all_win.push_back(e.first);
            else if(e.second == 1)
                one_lost.push_back(e.first);
        
        sort(all_win.begin(), all_win.end());
        sort(one_lost.begin(), one_lost.end());
        
        return {all_win, one_lost};
    }
};