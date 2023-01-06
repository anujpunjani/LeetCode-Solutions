class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        
        int ice_creams = 0;
        
        for(int cost : costs) {
            if(cost > coins) break;
            coins -= cost;
            ice_creams++;
        }
            
        return ice_creams;
    }
};