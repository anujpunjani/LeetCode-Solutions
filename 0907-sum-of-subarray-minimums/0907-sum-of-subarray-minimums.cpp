class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        long long int sum = 0;
        int mod = (int)1e9+7;
        stack<int> stk;
        
        for(int i = 0; i <= arr.size(); i++) {
            while(stk.size() > 0 && (i == arr.size() || arr[stk.top()] >= arr[i])) {
                int mid = stk.top(); stk.pop();
                int leftBoundary = stk.empty()? -1 : stk.top();
                int rightBoundary = i;
                
                long long int count = ((mid - leftBoundary) * (rightBoundary - mid))%mod;
                sum += (count * arr[mid]) % mod;
                sum %= mod;
            }
            
            stk.push(i);
        }
        
        return sum;
    }
};