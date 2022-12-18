class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        stack<int> stk;
        int n = temperatures.size();
        vector<int> ans(n, 0);
        
        for(int i = 0; i < n; i++) {
            while(stk.size() > 0 && temperatures[stk.top()] < temperatures[i]) {
                ans[stk.top()] = i - stk.top();
                stk.pop();
            }
            
            stk.push(i);
        }
        
        return ans;
    }
};