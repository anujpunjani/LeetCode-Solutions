class Solution {
public:
    string minWindow(string s, string t) {
        if(s.size() < t.size()) return "";
        if(s.find(t) != -1) return t;
        
        unordered_map<char, int> smap;
        unordered_map<char, int> tmap;
        
        for(char c : t) tmap[c]++;
        
        int window_size = INT_MAX, count = 0;
        int left = 0, start = 0;
        
        for(int i = 0; i < s.size(); i++) {
            int c = s[i];
            if(tmap.count(c)) {
                smap[c]++;
                if(smap[c] <= tmap[c]) count++;
            }
            
            while(count == t.size()) {
                
                int size = i + 1 - left;
                if(size < window_size) {
                    window_size = size;
                    start = left;
                }
                
                if(tmap.count(s[left])) {
                    smap[s[left]]--;
                    if(smap[s[left]] < tmap[s[left]])
                        count--;
                }
                
                left++;
            }
            
        }
        
        return window_size == INT_MAX? "": s.substr(start, window_size);
    }
};