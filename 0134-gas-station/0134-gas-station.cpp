class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int total_gas = accumulate(gas.begin(), gas.end(), 0);
        int total_cost = accumulate(cost.begin(), cost.end(), 0);
        
        if(total_gas < total_cost) return -1;
        
        int remaining_gas = 0;
        int start = 0;
        
        for(int i = 0; i < gas.size(); i++) {
            remaining_gas += gas[i] - cost[i];
            if(remaining_gas < 0) { 
                start = i + 1;
                remaining_gas = 0;
            }
        }
        
        return start;
    }
};