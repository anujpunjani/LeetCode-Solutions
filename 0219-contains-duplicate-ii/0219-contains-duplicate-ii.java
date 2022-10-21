class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!map.containsKey(num)) map.put(num, new ArrayList());
            map.get(num).add(i);
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            ArrayList<Integer> indicies = e.getValue();
            for(int i = 0; i < indicies.size() - 1; i++) {
                int val = Math.abs(indicies.get(i) - indicies.get(i + 1));
                if(val <= k) return true;
            }
        }
        
        return false;
    }
}