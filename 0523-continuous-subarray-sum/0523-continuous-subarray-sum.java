class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        if(k == 0)
            for(int i = 1; i < nums.length; i++)
                if(nums[i] == 0 && nums[i - 1] == 0) return true;
        
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int prefixSum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remainder = prefixSum%k;
            
            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) > 1)
                    return true;
            }
            
            map.putIfAbsent(remainder, i);
        }
        
        return false;
    }
}