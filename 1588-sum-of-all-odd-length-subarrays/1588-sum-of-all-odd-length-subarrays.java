class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length; i++) {
            
            int temp = ((n-i)*(i+1) + 1)/2;
            ans += arr[i]*temp; 
            
        }
        
        return ans;
    }
}