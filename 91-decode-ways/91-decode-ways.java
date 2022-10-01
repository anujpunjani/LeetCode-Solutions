class Solution {
    
    private int numDecodings(int idx, String s, int []dp) {
        if(idx == s.length()) return 1;
        if(dp[idx] != -1) return dp[idx];
        
        int ans = 0;
        
        if(s.charAt(idx) != '0')
            ans += numDecodings(idx + 1, s, dp);
        
        if(idx + 1 < s.length()) {
            int num = (s.charAt(idx) - '0') * 10 + s.charAt(idx + 1) - '0';
            if(num >= 10 && num <= 26)
                ans += numDecodings(idx + 2, s, dp);
        }
        
        return dp[idx] = ans;
     }
    
    public int numDecodings(String s) {
        int []dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(0, s, dp);
    }
}