class Solution {
    public int climbStairs(int n) {
        // Variance of Fibonnaci 
        
        int previous = 1;
        int current = 1;
        
        for(int i = 2; i <= n; i++) {
            int temp = previous + current;
            previous = current;
            current = temp;
        }
        
        return current;
    }
}