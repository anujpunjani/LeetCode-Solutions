class Solution {
    
    private int radixSort(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int num : nums) max = Math.max(max, num);
        
        int[] ans = nums;
        
        for(int exp = 1; max/exp > 0; exp*=10) {
            ans = countSort(ans, exp);
        }
        
        int gap = 0;
        
        for(int i = 1; i < nums.length; i++)
            gap = Math.max(gap, ans[i] - ans[i-1]);
        
        return gap;
    }
    
    private int[] countSort(int[] nums, int place) {
        
        int[] freq = new int[10];
        
        for(int num : nums)
            freq[(num/place)%10]++;

        int[] prefSum = new int[10];
        prefSum[0] = freq[0];
        for(int i = 1; i < 10; i++)
            prefSum[i] = freq[i] + prefSum[i - 1]; 
        
        int[] ans = new int[nums.length];
        for(int i = ans.length - 1; i >= 0; i--) {
            
            int pos = --prefSum[(nums[i]/place)%10];
            ans[pos] = nums[i];
            
        }
        
        return ans;
    }
    
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        return radixSort(nums);
    }
}