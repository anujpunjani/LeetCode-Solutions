class Solution {
    
    class Pair implements Comparable<Pair>{
        int stop;
        int color;
        int changes;
        
        Pair(int stop, int color, int changes) {
            this.stop = stop;
            this.color = color;
            this.changes = changes;
        }
        
        public int compareTo(Pair other) {
            return this.changes - other.changes;
        }
    }
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target) return 0;
        int n = 0;
        
        for(int[] route : routes)
            for(int stop : route)
                n = Math.max(stop, n);
        
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < routes.length; i++)
            for(int j = 0; j < routes[i].length; j++) {
                int src = routes[i][j];
                int dest = routes[i][(j + 1) % routes[i].length];
                
                graph[src].add(new Pair(dest, i, 0));
                graph[dest].add(new Pair(src, i, 0));
            }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, routes.length, 0));
        
        int[][] vis = new int[n + 1][routes.length + 1];
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= routes.length; j++)
                vis[i][j] = -1;
        
        while(pq.size() > 0) {
            
            Pair top = pq.remove();
            if(top.stop == target) return top.changes;
            
            if(vis[top.stop][top.color] != -1) continue;
            vis[top.stop][top.color] = top.changes;
            
            for(Pair nbr : graph[top.stop]) {
                if(nbr.color == top.color)
                    pq.add(new Pair(nbr.stop, nbr.color, top.changes));
                else
                    pq.add(new Pair(nbr.stop, nbr.color, top.changes + 1));
            }
            
        }
        
        return -1;
    }
}