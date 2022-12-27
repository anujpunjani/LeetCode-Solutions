class Solution {

private:
        static bool compare(const pair<int,int> &a, const pair<int,int> &b)
        {
            return abs(a.first - a.second) < abs(b.first - b.second);
        }
    
public:

    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        vector<pair<int, int>> v;
        
        for(int i = 0; i < rocks.size(); i++) {
            
            v.push_back({rocks[i], capacity[i]});
            
        }
        
        sort(v.begin(), v.end(), compare);
        
        int count = 0;
        
        for(int i = 0; i < rocks.size(); i++) {
            
            if(v[i].first != v[i].second && additionalRocks > 0) {
                
                int temp = abs(v[i].first - v[i].second);
                
                if(temp >= additionalRocks) {
                    v[i].first += additionalRocks;
                    additionalRocks = 0;
                } else {
                       
                    v[i].first += temp;
                    additionalRocks -= temp;
                }
               
            }
            
            if(v[i].first == v[i].second) count++;
            
        }
        
        return count;
    }
};