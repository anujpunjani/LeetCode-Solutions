class Solution {
public:
    
    class Compare {
        public:
            // Comparator function
            bool operator()(pair<int, int>& c1, pair<int, int>& c2)
            {
                double d1 = sqrt(c1.first * c1.first + c1.second * c1.second);
                double d2 = sqrt(c2.first * c2.first + c2.second * c2.second);
            
                return d1 > d2;
            }
    };
    
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> pq;
        
        for(auto point : points) {
            pq.push({point[0], point[1]});
        }
        
        vector<vector<int>> ans;
        
        while(k --> 0) {
            pair<int, int> point = pq.top();
            pq.pop();
            ans.push_back({point.first, point.second});
        }
        
        return ans;
    }
};