class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Arrays.sort(arr);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int num : arr) {
            
            if(map.getOrDefault(num, 0) > 0) {
                
                if(map.getOrDefault(num*2, 0) > 0) {
                    map.put(num, map.get(num) - 1);
                    map.put(num*2, map.get(num*2) - 1);
                }
                
            }
            
        }
        
        for(Integer val : map.values())
            if(val != 0) return false;
        
        return true;
    }
}