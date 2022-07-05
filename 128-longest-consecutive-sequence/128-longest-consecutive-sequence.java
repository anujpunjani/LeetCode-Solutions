class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int ans = 0;
        
        for(int num : nums)
            map.put(num, true);
        
        for(Integer start : map.keySet()) {
            
            if(!map.containsKey(start - 1)) {
                int count = 1;
                int temp = start + 1;
                while(map.containsKey(temp)) {
                    count++;
                    temp++;
                }
                
                ans = Math.max(ans, count);
            }
            
        }
        
        return ans;
    }
}