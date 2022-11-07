class Solution {
    public int maximum69Number (int num) {
        int digits = (int)Math.log10(num);
        int ans = 0;
        boolean onetime = true;
        while(digits > -1) {
            int n = num / (int)Math.pow(10, digits);
            n = n % 10;
            if(n == 6 && onetime) {
                ans = ans * 10 + 9;
                onetime = false;
            }
            else
                ans = ans * 10 + n;
            digits--;
        }
        
        return ans;
    }
}