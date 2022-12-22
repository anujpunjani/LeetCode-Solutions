class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int[] nodes = new int[n];
        int[] edgesDistance = new int[n];
        
        helper1(0, -1, nodes, edgesDistance, graph);
        helper2(0, -1, nodes, edgesDistance, graph);
        
        return edgesDistance;
    }
    
    private void helper1(int src, int parent, int[] nodes, int[] edges, ArrayList<Integer>[] graph) {
        
        for(Integer nbr : graph[src]) {
            
            if(nbr != parent) {
                helper1(nbr, src, nodes, edges, graph);
                nodes[src] += nodes[nbr];
                edges[src] += nodes[nbr] + edges[nbr];
            }
            
        }
        
        nodes[src]++;
    }
    
    private void helper2(int src, int parent, int[] nodes, int[] edges, ArrayList<Integer>[] graph) {
        
        for(Integer nbr : graph[src]) {
            
            if(nbr != parent) {
                edges[nbr] = edges[src] + nodes.length - 2*nodes[nbr];
                helper2(nbr, src, nodes, edges, graph);
            }
            
        }
    }
}