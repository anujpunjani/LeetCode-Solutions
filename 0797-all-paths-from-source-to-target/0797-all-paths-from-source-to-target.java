class Solution {
    
    List<List<Integer>> ans;
    
    private void allPaths(int src, int dest, int[][] graph, List<Integer> path, boolean[] vis) {
        
        if(src == dest) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(path);
            temp.add(src);
            ans.add(temp);
        }
        
        vis[src] = true;
        path.add(src);
        
        for(int v : graph[src]) {

            if(vis[v] == false) {

                allPaths(v, dest, graph, path, vis);

            }

        }
        
        path.remove(path.size() - 1);
        vis[src] = false;
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        ans = new ArrayList<>();
        
        allPaths(0, graph.length - 1, graph, new ArrayList<>(), new boolean[graph.length]);
        
        return ans;
        
    }
}