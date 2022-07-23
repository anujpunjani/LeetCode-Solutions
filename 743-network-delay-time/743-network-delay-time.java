class Solution {
    
    class Pair implements Comparable<Pair> {
        int node;
        int weight;
        
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        n++;
        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : times)
            graph[edge[0]].add(new Pair(edge[1], edge[2]));
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));
        
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        vis[0] = 0;

        while(pq.size() > 0) {
            
            Pair top = pq.remove();
            
            if(vis[top.node] != -1) continue;
            vis[top.node] = top.weight;
            
            for(Pair nbr : graph[top.node])
                pq.add(new Pair(nbr.node, nbr.weight + top.weight));
            
        }
        
        int ans = 0;
        for(int val : vis)
            if(val == -1) return -1;
            else ans = Math.max(ans, val);
        return ans;
    }
}