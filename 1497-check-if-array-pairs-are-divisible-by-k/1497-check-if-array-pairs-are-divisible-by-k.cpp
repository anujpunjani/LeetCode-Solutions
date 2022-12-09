class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        vector<int> freq(k, 0);
        
        for(int val : arr)
            freq[((val % k) + k) % k]++;
        
        int i = 1;
        if(freq[0]%2 != 0) return false;
        while(i <= k/2) {
            if(freq[i] != freq[k - i]) return false;
            i++;
        }
        
        return true;
    }
};