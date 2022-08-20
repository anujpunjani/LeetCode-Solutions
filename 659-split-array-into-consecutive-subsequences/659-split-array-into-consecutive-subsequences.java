class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> am = new HashMap<>();
        HashMap<Integer, Integer> vm = new HashMap<>();
        
        for(int val : nums)
            am.put(val, am.getOrDefault(val, 0) + 1);
        
        for(int val : nums) {
            if(am.get(val) == 0) continue;
            else if(vm.getOrDefault(val, 0) > 0) {
                
                am.put(val, am.get(val) - 1);
                vm.put(val, vm.get(val) - 1);
                vm.put(val + 1, vm.getOrDefault(val + 1, 0) + 1);
                
            } else if(am.getOrDefault(val, 0) > 0 && am.getOrDefault(val + 1, 0) > 0 && am.getOrDefault(val + 2, 0) > 0) {
                
                am.put(val, am.get(val) - 1);
                am.put(val + 1, am.get(val + 1) - 1);
                am.put(val + 2, am.get(val + 2) - 1);
                vm.put(val + 3, vm.getOrDefault(val + 3, 0) + 1);
                
            } else 
                return false;
        }
        
        return true;
    }
}