class Solution {
    long count = 0;
    private void countComps(HashSet<Integer>[] graph, int src, boolean[] vis) {
        
        vis[src] = true;
        count++;
        for(Integer nbr : graph[src]) {
            if(vis[nbr] == false)
                countComps(graph, nbr, vis);
        }
        
    }
    
    public long countPairs(int n, int[][] edges) {
        
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++)
            graph[i] = new HashSet<>();
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        
        long ans = 0;
        
        for(int i = 0; i < n; i++) {
            if(vis[i] == false) {
                count = 0;
                countComps(graph, i, vis);
                ans += (count * (n*1l - count));
            }
        }

        
        return ans/2l;
    }
}