class Solution {
public:
    int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for(int j = 1; j < n; j++) {
            
            int temp_a = (e + u + i) % mod;
            int temp_e = (a + i) % mod;
            int temp_i = (e + o) % mod;
            int temp_o = i % mod;
            int temp_u = (o + i) % mod;
            
            a = temp_a;
            e = temp_e;
            i = temp_i;
            o = temp_o;
            u = temp_u;
        }
        
        return (a + e + i + o + u) % mod;
    }
};