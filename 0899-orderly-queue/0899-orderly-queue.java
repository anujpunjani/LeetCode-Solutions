class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 0) return s;
        if(k > 1) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
        
        String ans = s;
        
        for(int i = 1; i < s.length(); i++) {
            String sub = s.substring(i) + s.substring(0, i);
            if(sub.compareTo(ans) < 0)
                ans = sub;
        }
        
        return ans;
    }
}