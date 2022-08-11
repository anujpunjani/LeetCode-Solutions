class Solution {
    
    class Pair implements Comparable<Pair>{
        int node;
        double weight;
        
        Pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Pair other) {
            if(other.weight > this.weight)
                return 1;
            else if(other.weight < this.weight)
                return -1;
            return 0;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            graph[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }
     
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 1.0));
        
        double[] vis = new double[n];
        Arrays.fill(vis, -1.0);
        
        while(pq.size() > 0) {
            
            Pair top = pq.remove();
            if(vis[top.node] != -1.0) continue;
            vis[top.node] = top.weight;
            
            if(top.node == end) return vis[top.node];
            
            for(Pair nbr : graph[top.node]) {
                pq.add(new Pair(nbr.node, top.weight * nbr.weight));
            }
            
        }
        
        return 0;
    }
}