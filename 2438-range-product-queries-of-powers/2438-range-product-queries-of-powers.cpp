class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        vector<int> powers;
        for(int i = 0; i < 32; ++i){
            if((n & (1<<i)) != 0) powers.push_back(1<<i);
        }
        
        vector<int> ans(queries.size());
        int index = 0;
        for(auto query : queries) {
            long temp = 1;
            for(int i = query[0]; i <= query[1]; i++) {
                temp = (temp * powers[i]) % 1000000007;
            }
            ans[index] = (int)temp;
            index++;
        }
        
        return ans;
    }
};