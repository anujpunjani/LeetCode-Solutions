class Solution {
public:
    string countAndSay(int n) {
        string ans = "1";
        
        for(int i = 2; i <= n; i++) {
            string temp = "";
            int count = 0;
            int j = 0;
            while(j < ans.size() - 1) {
                if(ans[j] == ans[j + 1])
                    count++;
                else {
                    temp += to_string(count + 1);
                    temp += ans[j];
                    count = 0;
                }
                j++;
            }
            
            temp += to_string(count + 1);
            temp += ans[j];
            ans = temp;
        }
        
        return ans;
    }
};