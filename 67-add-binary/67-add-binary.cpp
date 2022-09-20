class Solution {
public:
    string addBinary(string a, string b) {
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        
        int carry = 0;
        
        int i = 0, j = 0;
        
        string ans = "";
        
        while(i < a.size() || j < b.size() || carry != 0) {
            int d1 = i < a.size()? a[i] - '0' : 0;
            int d2 = j < b.size()? b[j] - '0' : 0;
            
            int d = d1 + d2 + carry;
            carry = d / 2;
            
            ans += to_string(d % 2);
            i++;
            j++;
        }
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};