class Solution {
    int count = 1;
    private void helper(int[] nums, int idx, boolean last) {
        
        if(idx == nums.length)
            return;
        
        if(last == true && nums[idx-1] - nums[idx] < 0) {
            count++;
            last = false;
            helper(nums, idx + 1, last);
        } else if(nums[idx-1] - nums[idx] > 0) {
            count++;
            last = true;
            helper(nums, idx + 1, last);
        } else {
            helper(nums, idx + 1, last);
        }
        
    }
    
    public int wiggleMaxLength(int[] nums) {
        
        int i = 1, count = 0, last = 0;
        
        while(i < nums.length) {
            
            if((last == 0 || last < 0) && nums[i] - nums[i-1] > 0) {
                
                last = nums[i] - nums[i-1];
                count++;
                i++;
            } else if((last == 0 || last > 0) && nums[i] - nums[i-1] < 0){
                last = nums[i] - nums[i-1];
                count++;
                i++;
            } else {
                i++;
            }
            
        }
        
        return count+1;
    }
}