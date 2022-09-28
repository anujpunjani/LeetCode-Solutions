class Solution {
    public int longestContinuousSubstring(String s) {
        StringBuilder sb = new StringBuilder("");
        int ans = 1;
        
        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(sb.charAt(sb.length() - 1) == c - 1)
                sb.append(c);
            else {
                sb = new StringBuilder("");
                sb.append(c);
            }
            
            ans = Math.max(ans, sb.length());
        }
        
        return ans;
    }
}