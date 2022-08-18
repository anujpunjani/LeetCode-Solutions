class Solution {
public:
    
    static bool Compare(pair<int, int> p1, pair<int, int> p2) {
        return p1.second < p2.second;
    }
    
    int minSetSize(vector<int>& arr) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, function<bool(pair<int, int>, pair<int, int>)>> pq(Compare);
        
        unordered_map<int, int> m;
        for(int val : arr)
            m[val]++;
        
        for(auto e : m)
            pq.push({e.first, e.second});
        
        int count = 0;
        int reduced_size = 0;
        
        while(pq.size() > 0) {
            count++;
            reduced_size += pq.top().second;
            pq.pop();
            
            if(reduced_size >= arr.size()/2) return count;
        }
        
        return count;
    }
};