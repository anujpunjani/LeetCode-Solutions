class Solution {
    
    private int numDecodings(int idx, String s, int []dp) {
        if(idx == s.length()) return 1;
        if(dp[idx] != 0) return dp[idx];
        
        int ans = 0;
        int ch1 = s.charAt(idx) - '0';
        
        if(ch1 >= 1 && ch1 <= 9) 
            ans += numDecodings(idx + 1, s, dp);
        
        if(idx + 1 < s.length()) {
            int ch2 = s.charAt(idx + 1) - '0';
            int num = ch1 * 10 + ch2;
            if(num >= 10 && num <= 26)
                ans += numDecodings(idx + 2, s, dp);
        }
        
        return dp[idx] = ans;
     }
    
    public int numDecodings(String s) {
        return numDecodings(0, s, new int[s.length() + 1]);
    }
}