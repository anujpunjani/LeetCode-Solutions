class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            int j = i + 1, k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            while(j < k) {
                if(i != j && j != k && k != i) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if(sum == target) {
                        ans = sum;
                        break;
                    }
                    
                    if(Math.abs(sum - target) < diff) {
                        diff = Math.abs(sum - target);
                        ans = sum;
                    }
                    
                    if(sum > target)
                        k--;
                    else
                        j++;
                }
            }
            
        }
        
        return ans;
    }
}