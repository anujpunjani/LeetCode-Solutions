class Solution {
public:
    
    bool isPalindrome(string s) {
        int i = 0, j = s.size()-1;
        while(i <= j) if(s[i++] != s[j--]) return false;
        return true;
    }
    
    void partition(int idx, string s, vector<string> subs, vector<vector<string>> &ans) {
        if(idx == s.size()) {
            ans.push_back(subs);
            return;
        }
        
        for(int i = idx; i < s.size(); i++) {
            string sub = s.substr(idx, i - idx + 1);
            if(isPalindrome(sub)) {
                subs.push_back(sub);
                partition(i + 1, s, subs, ans);
                subs.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        partition(0, s, vector<string>(), ans);
        return ans;
    }
};