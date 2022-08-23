class Solution {
    
    private int powerOfThree(int n) {
        int power = 0;
        while(n > 1) {
            n /= 3;
            power++;
        }
        
        return (int) Math.pow(3, power);
    }
    
    public boolean checkPowersOfThree(int n) {
        
        if(n == 0) return false;
        
        while(n > 0)
            n -= powerOfThree(n);
        
        return n == 0 || n == 1? true : false;
    }
}