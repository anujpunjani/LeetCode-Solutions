class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target) return 0;
        
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashSet<Integer> busesVisited = new HashSet();
        HashSet<Integer> StopsVisited = new HashSet();
        
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                
                if(!graph.containsKey(routes[i][j]))
                    graph.put(routes[i][j], new HashSet<>());
                
                graph.get(routes[i][j]).add(i);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        StopsVisited.add(source);
        int changes = 0;
        
        while(q.size() > 0) {
            
            int size = q.size();
            while(size --> 0) {
                int front = q.remove();
                if(front == target) return changes;
                
                HashSet<Integer> buses = graph.get(front);
                for(int bus : buses) {
                    
                    if(busesVisited.contains(bus))
                        continue;
                    
                    int[] stops = routes[bus];
                    for(int stop : stops) {
                        if(StopsVisited.contains(stop))
                            continue;
                        q.add(stop);
                        StopsVisited.add(stop);
                    }
                    busesVisited.add(bus);
                }
            }
            changes++;
        }
        
        return -1;
    }
}