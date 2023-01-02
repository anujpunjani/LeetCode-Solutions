class Solution {
public:
    bool detectCapitalUse(string word) {
        int upper = 0, lower = 0, size = word.size();
        
        for(char c : word) {
            if(isupper(c)) upper++;
            if(islower(c)) lower++;
        }
        
        return lower == size || upper == size || (upper == 1 && isupper(word[0])); 
    }
};