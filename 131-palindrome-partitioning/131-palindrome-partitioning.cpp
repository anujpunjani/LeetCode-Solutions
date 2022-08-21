class Solution {
public:
    
    bool isPalindrome(string s, int left, int right) {
        while(left <= right) {
            if(s[left++] != s[right--])
                return false;
        }
        return true;
    }
    
    void partition(int index, string s, vector<string> path, vector<vector<string>> &ans) {
        
        if(index == s.size()) {
            ans.push_back(path);
            return;
        }
        
        for(int i = index; i < s.size(); i++) {
            if(isPalindrome(s, index, i)) {
                path.push_back(s.substr(index, i - index + 1));
                partition(i + 1, s, path, ans);
                path.pop_back();
            }
        }
    }
    
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        partition(0, s, vector<string>(), ans);
        return ans;
    }
};