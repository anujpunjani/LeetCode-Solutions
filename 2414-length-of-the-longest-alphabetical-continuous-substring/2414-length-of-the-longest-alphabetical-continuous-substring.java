class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int count = 1;
        
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char pc = s.charAt(i - 1);
            if(pc == c - 1)
                count++;
            else 
                count = 1;
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}