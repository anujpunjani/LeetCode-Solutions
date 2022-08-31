class Solution {
public:
    
    class Compare {
      public:
        bool operator() (pair<int, int> a, pair<int, int> b) {
            int p1 = a.first * a.first + a.second * a.second;
            int p2 = b.first * b.first + b.second * b.second;
            
            return p1 > p2;
        }
    };
    
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> pq;
        
        for(auto point : points)
            pq.push({point[0], point[1]});
        
        vector<vector<int>> ans;
        
        while(k --> 0) {
            auto point = pq.top();
            pq.pop();
            ans.push_back({point.first, point.second});
        }
        
        return ans;
    }
};