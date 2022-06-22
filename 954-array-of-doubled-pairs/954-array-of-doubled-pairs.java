class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : map.keySet()) {
            
            if(map.getOrDefault(num, 0) > 0) {
                
                int target = 0;
                
                if(num < 0) target = num / 2;
                else target = num * 2;
                
                if(num < 0 && num%2 != 0) return false;
                
                if(map.get(num) > map.getOrDefault(target, 0)) return false;
                    
                map.put(target, map.get(target) - map.get(num));
                       
            }
            
        }
        
        return true;
    }
}