class Solution {
public:
    bool can_replace(int pos, string target, string stamp) {
        for(int i = 0; i < stamp.size(); i++)
            if(target[i + pos] != '?' && target[i + pos] != stamp[i])
                return false;
        return true;
    }
    
    void replace(int pos, int size, string &target, int &count) {
        for(int i = 0; i < size; i++) {
            if(target[i + pos] != '?') {
                target[i + pos] = '?';
                count++;
            }   
        }
    }
    
    vector<int> movesToStamp(string stamp, string target) {
        
        int count = 0;
        vector<bool> vis(target.size(), false);
        
        vector<int> ans;
        
        while(count != target.size()) {
            bool didChange = false;
            for(int i = 0; i <= target.size() - stamp.size(); i++) {
                if(vis[i] == false && can_replace(i, target, stamp)) {
                    replace(i, stamp.size(), target, count);
                    vis[i] = true;
                    
                    ans.push_back(i);
                    didChange = true;
                    
                    if(count == target.size()) break;
                }
            }
            
            if(!didChange) return vector<int>();
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};