class Solution {
    public int[] findOriginalArray(int[] changed) {
        if((changed.length&1) == 1) return new int[0];
        Map<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[changed.length/2];
        
        for(int val : changed)
            map.put(val, map.getOrDefault(val, 0) + 1);
        
        int i = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();

            if(value == 0) continue;
            if(!map.containsKey(2*key) || value > map.get(2*key)) return new int[0];
            if(key == 0) value /= 2;
            
            map.put(2*key, map.get(2*key) - value);
            map.put(key, 0);
            while(value --> 0) ans[i++] = key;
            
            if(i == changed.length/2) break;
        }
        
        return ans;
    }
}