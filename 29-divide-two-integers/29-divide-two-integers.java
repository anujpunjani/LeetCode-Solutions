class Solution {
    public int divide(int dividend, int divisor) {
        
        int signend = dividend < 0? -1 : 1;
        int signsor = divisor < 0? -1 : 1;
               
        if(dividend ==  Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;       
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0;
        
        while(dividend - divisor >= 0) {
            int temp = divisor;
            int count = 1;
            
            while(dividend - (temp << 1) >= 0) {
                temp <<= 1;
                count <<= 1;
            }
            
            dividend -= temp;
            quotient += count;
        }
        
        return quotient * signend * signsor;
    }
}