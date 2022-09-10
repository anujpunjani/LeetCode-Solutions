class Solution {
public:
    
    static bool compare (const vector<int> &a, const vector<int>& b) { 
        
        if(a[0] != b[0]) 
            return a[0] > b[0]; 
        
        return a[1] < b[1]; 
    }
    
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        sort(properties.begin(), properties.end(), compare);
        
        int ans = 0;
        int maxTill = INT_MIN;
        
        for(auto p : properties) {
            
            if(maxTill > p[1])
                ans++;
            else
                maxTill = p[1];
        }
        
        return ans;
    }
};