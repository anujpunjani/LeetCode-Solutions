class Solution {
public:
    int countVowelPermutation(int n) {
        int mod = (int)1e9 + 7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for(int j = 2; j <= n; j++) {
            
            long new_a = (e + i + u) % mod;
            long new_e = (a + i) % mod;
            long new_i = (e + o) % mod;
            long new_o = i % mod;
            long new_u = (i + o) % mod;
            
            a = new_a;
            e = new_e;
            i = new_i;
            o = new_o;
            u = new_u;
        }
        
        return (a + e + i + o + u) % mod;
    }
};