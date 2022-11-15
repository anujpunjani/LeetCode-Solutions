class Solution {
    
    private void dfs(int idx, int[][] stones, boolean[] vis) {
        
        if(vis[idx]) return;
        
        vis[idx] = true;
        
        for(int i = 0; i < stones.length; i++)
            if(stones[idx][0] == stones[i][0] || stones[idx][1] == stones[i][1])
                dfs(i, stones, vis);
    }
    
    public int removeStones(int[][] stones) {
        boolean[] vis = new boolean[stones.length];
        
        int remaining = 0;
        for(int i = 0; i < stones.length; i++){
            if(vis[i]) continue;
            remaining++;
            dfs(i, stones, vis);
        }
        
        
        return stones.length - remaining;
    }
}