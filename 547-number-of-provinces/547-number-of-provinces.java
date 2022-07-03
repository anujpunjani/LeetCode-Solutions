class Solution {
    
    private void dfs(ArrayList<Integer>[] graph, int src, boolean[] vis) {
        
        vis[src] = true;
        
        for(int nbr : graph[src])
            if(vis[nbr] == false)
                dfs(graph, nbr, vis);
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {   
                if(i != j && isConnected[i][j] == 1)
                    graph[i].add(j);
            }
        }
        
        int comps = 0;
        
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(vis[i] == false) {
                dfs(graph, i, vis);
                comps++;                
            }
        }
        
        return comps;
    }
}