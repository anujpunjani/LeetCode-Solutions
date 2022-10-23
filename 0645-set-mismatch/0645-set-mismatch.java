class Solution {
    public int[] findErrorNums(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            if(nums[index] == nums[i]) continue;
            
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            i--;
            
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) return new int[]{nums[i], i + 1};
        }
        
        return new int[]{-1, -1};
    }
}