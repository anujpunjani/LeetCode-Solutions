class Solution {
public:
    class Compare {
        public:
            bool operator()(pair<int, int> a, pair<int, int> b) {
                return a.first < b.first;
            }
    };
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> pq;
        vector<int> ans;

        for(int i = 0; i < nums.size(); i++) {
            
            while(pq.size() > 0 && pq.top().second <= i - k)
                pq.pop();
            
            pq.push({nums[i], i});
            
            if(i >= k - 1)
                ans.push_back(pq.top().first);
        }
        
        return ans;
    }
};