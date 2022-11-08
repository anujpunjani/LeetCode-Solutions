class Solution {
public:
    string makeGood(string s) {
        stack<char> stk;
        for(int i = 0; i < s.size(); i++) {
            
            if(stk.size() > 0 && ((char)(stk.top() - 32) == s[i] || (char)(stk.top() + 32) == s[i]))
                stk.pop();
            else
                stk.push(s[i]);
        }
        
        string ans = "";
        while(stk.size() > 0) {
            ans += stk.top();
            stk.pop();
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};