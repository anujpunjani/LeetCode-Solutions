class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] ans = new char[n];
        int[] toLeft = new int[n];
        int[] toRight = new int[n];
        
        int nearestRight = -1;
        for(int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if(c == 'L') nearestRight = -1;
            else if(c == 'R') nearestRight = i;
            toRight[i] = nearestRight;
        }

        int nearestLeft = -1;
        for(int j = n - 1; j >= 0; j--) {
            char c = dominoes.charAt(j);
            if(c == 'R') nearestLeft = -1;
            else if(c == 'L') nearestLeft = j;
            toLeft[j] = nearestLeft;
        }
        
        for(int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            int left = toLeft[i] == -1? Integer.MAX_VALUE : Math.abs(i - toLeft[i]);
            int right = toRight[i] == -1? Integer.MAX_VALUE : Math.abs(i - toRight[i]);
            
            if(c == 'L' || c == 'R') ans[i] = c;
            else if(left > right) ans[i] = 'R';
            else if(left < right) ans[i] = 'L';
            else ans[i] = '.';
        }
        
        return new String(ans);
    }
}