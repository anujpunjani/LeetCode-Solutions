class Solution {
public:
    
    class Compare {
        public:
            bool operator()(pair<char, int> a, pair<char, int> b) {
                if(a.second == b.second) return a.first > b.first;
                return a.second < b.second;
            }
    };
    
    string reorganizeString(string s) {
        unordered_map<char, int> m;
        string ans = "";
        
        for(char ch : s) m[ch]++;
        
        priority_queue<pair<char, int>, vector<pair<char,int>>, Compare> pq;
        
        for(auto e : m)
            pq.push({e.first, e.second});
        
        while(pq.size() > 0) {
            auto odd = pq.top(); pq.pop();
            ans += odd.first;
            odd.second--;
            
            if(pq.size() == 0 && odd.second > 0) return "";
            
            if(pq.size() > 0) {
                auto even = pq.top(); pq.pop();
                ans += even.first;
                even.second--;
                if(even.second) pq.push(even);
            }
            
            if(odd.second) pq.push(odd);
        }
        
        return ans;
    }
};