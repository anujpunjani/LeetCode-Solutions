class Solution {
public:
    
    class Compare {
      public:
        bool operator()(pair<int, int> a, pair<int, int> b) {
            return a.second > b.second;
        }
    };
    
    vector<int> topKFrequent(vector<int>& nums, int k) {
        priority_queue<pair<int, int>, vector<pair<int,int>>, Compare> pq;
        unordered_map<int, int> m;
        
        for(int num : nums)
            m[num]++;
        
        for(auto num : m) {
            if(pq.size() == k) {
                if(pq.top().second < num.second) {
                    pq.pop();
                    pq.push({num.first, num.second});
                }
            } else 
                pq.push({num.first, num.second});
        }
        vector<int> ans;
        while(pq.size() > 0) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        
        return ans;
    }
};