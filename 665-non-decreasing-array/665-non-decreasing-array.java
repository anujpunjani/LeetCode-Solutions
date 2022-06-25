class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int check = 0;
        for(int i = 1; i < nums.length; i++)
            if(nums[i] < nums[i-1]) {
                check++;
                if(check > 1) return false;
                if(i == 1 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];    
                else nums[i] = nums[i-1];
            }
        
        return true;
    }
}