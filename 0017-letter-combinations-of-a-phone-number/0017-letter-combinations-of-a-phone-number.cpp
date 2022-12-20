class Solution {
public:
    
    unordered_map<char, string> keys;

    void letterCombinations(string digits, string letters, vector<string> &ans) {
        
        if(digits.size() == 0) {
            ans.push_back(letters);
            return;
        }
        
        string temp = keys[digits[0]];

        for(int i = 0; i < temp.size(); i++)
            letterCombinations(digits.substr(1), letters + temp[i], ans);
        
    }
    
    vector<string> letterCombinations(string digits) {
        keys['2'] = "abc";
        keys['3'] = "def";
        keys['4'] = "ghi";
        keys['5'] = "jkl";
        keys['6'] = "mno";
        keys['7'] = "pqrs";
        keys['8'] = "tuv";
        keys['9'] = "wxyz";
        
        vector<string> ans;
        if(digits.size() == 0) return ans;
        
        letterCombinations(digits, "", ans);
        return ans;
    }
};