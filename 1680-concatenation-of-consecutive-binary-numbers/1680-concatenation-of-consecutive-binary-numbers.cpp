class Solution {
public:
    int concatenatedBinary(int n) {
        int mod = 1e9 + 7;
        int ans = 0;
        int multiplier = 1;
        
        for(int i = n; i >= 1; i--) {
            int temp = i;
            while(temp != 0) {
                if((temp&1) == 1) ans = (ans + multiplier) % mod;
                multiplier = (multiplier * 2) % mod;
                temp >>= 1;
            }
        }
        
        return ans;
    }
};