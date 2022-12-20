class Solution {
    
    private void dfs(int src, List<List<Integer>> rooms, HashSet<Integer> set) {
        
        if(set.contains(src)) return;
        
        set.add(src);
        
        for(Integer key : rooms.get(src))
            dfs(key, rooms, set);
        
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> set = new HashSet();
        
        dfs(0, rooms, set);
        
        return set.size() == n;
    }
}