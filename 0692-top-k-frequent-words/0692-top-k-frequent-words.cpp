class Solution {
public:
    
    class compare {
        public:
            bool operator()(const pair<string, int> &p1, const pair<string, int> &p2) {
                if(p1.second == p2.second)
                    return p1.first < p2.first;
                return p1.second > p2.second;
            }
    };
    
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> m;
        for(string word : words) m[word]++;

        priority_queue<pair<string, int>, vector<pair<string, int>>, compare> pq;
        for(auto item : m) {
            if(pq.size() == k) {
                if(pq.top().second < item.second || (pq.top().second == item.second && pq.top().first > item.first)) {
                    pq.pop();
                    pq.push({item.first, item.second});
                }
            } else
                pq.push({item.first, item.second});
        }
        
        vector<string> ans;
        while(!pq.empty()) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};